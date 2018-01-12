package bean;


public class TProjectOrganiser {
    private Integer id;

    private String remark;

    private String desc;

    private Integer phone;

    private Integer servicephone;

    private Integer paycard;

    private Integer legalcard;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Integer getServicephone() {
        return servicephone;
    }

    public void setServicephone(Integer servicephone) {
        this.servicephone = servicephone;
    }

    public Integer getPaycard() {
        return paycard;
    }

    public void setPaycard(Integer paycard) {
        this.paycard = paycard;
    }

    public Integer getLegalcard() {
        return legalcard;
    }

    public void setLegalcard(Integer legalcard) {
        this.legalcard = legalcard;
    }
}