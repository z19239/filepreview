package cn.keking.model.easyExcel;

import lombok.Builder;
import lombok.Data;

//上传exl读取的返回值
@Data
@Builder
public class EasyexlMessage {
    private String msg;//提示
    private long successco;//成功数量
    private long failco;//失败数量
    private String failpath; //失败文件路径
}
