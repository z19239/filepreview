package cn.keking.mapper;


import cn.keking.model.VerifyCode;

import java.util.List;

/**
 * Created by zc on 2018/12/3.
 */
public interface IVerifyCodeRepositoryMapper {
    //保存的时候判断有没有重复
    VerifyCode findVerifyCodeByCustomNameAndOperatePersonAndRegisterCode(String customName, String operatePerson,
                                                                         String registerCode);


    VerifyCode save(VerifyCode verifyCode);

    List<VerifyCode> findVerifyCodeByCustomName(String customName);

    List<VerifyCode> findVerifyCodeByRegisterCode(String registerCode);

    //根据id修改状态
   int modifyStateById(boolean state, Integer id);

    int setVerifyCode(boolean b, String customName, String operatePerson, String registerCode);
}
