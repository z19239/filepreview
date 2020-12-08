package cn.keking.model.database.domain;

import java.util.Date;
import lombok.Data;

@Data
public class Inventory {
    private Integer autoid;

    private String caccId;

    private String cinvcode;

    private String cinvaddcode;

    private String cinvname;

    private String cinvstd;

    private String cinvccode;

    private String cinvcname;

    private String ccomunitcode;

    private String ccomunitname;

    private Date dedate;

    private Boolean binvbatch;

    private Boolean binvquality;

    private Boolean bpurchase;

    private Boolean bself;

    private Boolean bproxyforeign;

    private Boolean bsale;

    private Boolean bfree1;

    private Boolean bfree2;

    private Date dcreatedate;

    private Short imodifycounts;

    private String clastmodifier;

    private Date dlastmodifydate;

    private Boolean bmesisread;

    private Date dmesreaddate;

    private String cinvdefine1;

    private String cinvdefine2;

    private String cinvdefine3;

    private String cinvdefine4;

    private String cinvdefine5;

    private String cinvdefine6;

    private String cinvdefine7;

    private String cinvdefine8;

    private String cinvdefine9;

    private String cinvdefine10;

    private Integer cinvdefine11;

    private Integer cinvdefine12;

    private Double cinvdefine13;

    private Double cinvdefine14;

    private Date cinvdefine15;

    private Date cinvdefine16;

    private String cinvmnemcode;

    private Short imassdate;

    private Short cmassunit;

    private Boolean bfree3;

    private Boolean bfree4;

    private Boolean bfree5;

    private Boolean bfree6;

    private Boolean bfree7;

    private Boolean bfree8;

    private Boolean bfree9;

    private Boolean bfree10;
}