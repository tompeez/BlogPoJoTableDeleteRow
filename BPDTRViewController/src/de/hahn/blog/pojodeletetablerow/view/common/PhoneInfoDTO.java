package de.hahn.blog.pojodeletetablerow.view.common;

public class PhoneInfoDTO {
    Integer Sequence;
    String PhoneType;
    String PhoneNumber
        ;
    public PhoneInfoDTO() {
        super();
    }

    public void setSequence(Integer Sequence) {
        this.Sequence = Sequence;
    }

    public Integer getSequence() {
        return Sequence;
    }

    public void setPhoneType(String Type) {
        this.PhoneType = Type;
    }

    public String getPhoneType() {
        return PhoneType;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }
}
