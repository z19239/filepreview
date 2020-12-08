package cn.keking.service.impl;

import cn.keking.mapper.IVerifyCodeRepositoryMapper;
import cn.keking.model.VerifyCode;
import cn.keking.service.IVerifyCodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerifyCodeServiceImpl implements IVerifyCodeService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IVerifyCodeRepositoryMapper iVerifyCodeRepositoryMapper;

    @Override
    public List<VerifyCode> findVerifyCodeByCustomName(String customName) {
        return iVerifyCodeRepositoryMapper.findVerifyCodeByCustomName(customName);
    }

    @Override
    public int modifyVerifyState(VerifyCode verifyCode) {
        return iVerifyCodeRepositoryMapper.setVerifyCode(true, verifyCode.getCustomName(), verifyCode.getOperatePerson(),
            verifyCode.getRegisterCode());
    }

    @Override
    public boolean save(VerifyCode verifyCode) {
        boolean result = false;
        VerifyCode verifyCodeList = iVerifyCodeRepositoryMapper.findVerifyCodeByCustomNameAndOperatePersonAndRegisterCode(
            verifyCode.getCustomName(), verifyCode.getOperatePerson(), verifyCode.getRegisterCode());
        if (verifyCodeList == null) {
            iVerifyCodeRepositoryMapper.save(verifyCode);
            result = true;
        }
        return result;
    }

    @Override
    public VerifyCode findVerifyCodeByCOR(String customName, String operatePerson, String registerCode) {
        return iVerifyCodeRepositoryMapper.findVerifyCodeByCustomNameAndOperatePersonAndRegisterCode(customName,
            operatePerson, registerCode);
    }

    @Override
    public boolean isValid(String registerCode) {
        boolean result = false;
        registerCode = registerCode.trim();
        List<VerifyCode> verifyCodeList = iVerifyCodeRepositoryMapper.findVerifyCodeByRegisterCode(registerCode);
        for (int i = 0; i < verifyCodeList.size(); i++) {
            VerifyCode verifyCode = verifyCodeList.get(i);
            if (!verifyCode.isState()) {
                int temp = iVerifyCodeRepositoryMapper.modifyStateById(true, verifyCode.getId());
                logger.warn("modifyStateById result:{}", temp);
                if (temp != -1) {
                    result = true;
                }
                break;
            }
        }
        return result;
    }

}
