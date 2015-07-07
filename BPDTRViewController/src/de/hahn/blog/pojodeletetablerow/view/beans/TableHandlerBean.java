package de.hahn.blog.pojodeletetablerow.view.beans;


import de.hahn.blog.pojodeletetablerow.view.common.PhoneInfoDTO;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.event.ActionEvent;

import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.context.AdfFacesContext;


public class TableHandlerBean {
    private static ADFLogger logger = ADFLogger.createADFLogger(TableHandlerBean.class);
    ArrayList<PhoneInfoDTO> phoneInfoList;
    Integer currentSelectedIndex;

    public TableHandlerBean() {
    }

    private void initList() {
        if (phoneInfoList != null) {
            phoneInfoList.clear();
        }
        phoneInfoList = new ArrayList<PhoneInfoDTO>();
        PhoneInfoDTO dto1 = new PhoneInfoDTO();
        dto1.setSequence(1);
        dto1.setPhoneNumber("(408)250-0438");
        dto1.setPhoneType("BUSN");
        phoneInfoList.add(dto1);
        PhoneInfoDTO dto2 = new PhoneInfoDTO();
        dto2.setSequence(2);
        dto2.setPhoneNumber("(408)250-0439");
        dto2.setPhoneType("CELL");
        phoneInfoList.add(dto2);
        PhoneInfoDTO dto3 = new PhoneInfoDTO();
        dto3.setSequence(3);
        dto3.setPhoneNumber("(408)250-0430");
        dto3.setPhoneType("SMS");
        phoneInfoList.add(dto3);
        PhoneInfoDTO dto4 = new PhoneInfoDTO();
        dto4.setSequence(4);
        dto4.setPhoneNumber("(408)250-5678");
        dto4.setPhoneType("FAX");
        phoneInfoList.add(dto4);
        logger.info("List initalized");
    }

    public String cb1_action() {
        // Add event code here...
        return null;
    }

    public void setPhoneInfoList(List<PhoneInfoDTO> phoneInfoList) {
        this.phoneInfoList = new ArrayList<PhoneInfoDTO> (phoneInfoList);
    }

    public List<PhoneInfoDTO> getPhoneInfoList() {
        // layz init ist
        if (phoneInfoList == null) {
            initList();
        }
        return phoneInfoList;
    }

    public void onRemoveAction(ActionEvent actionEvent) {
        Integer currentIndex = getCurrentSelectedIndex();
        logger.info("Removing with index : >> " + currentIndex);
        logger.info("Removing with size : >> " + phoneInfoList.size());
        logger.info("Value in List ** " + phoneInfoList.get(currentIndex).getSequence() + " phone " + phoneInfoList.get(currentIndex).getPhoneType());
        phoneInfoList.remove(currentIndex.intValue());
        logger.info("size after removing : >> " + phoneInfoList.size());
        UIComponent ui = (UIComponent)actionEvent.getSource();
        AdfFacesContext.getCurrentInstance().addPartialTarget(ui.getParent().getParent().getParent());
    }

    public void setCurrentSelectedIndex(Integer currentSelectedImdex) {
        this.currentSelectedIndex = currentSelectedImdex;
    }

    public Integer getCurrentSelectedIndex() {
        return currentSelectedIndex;
    }
}
