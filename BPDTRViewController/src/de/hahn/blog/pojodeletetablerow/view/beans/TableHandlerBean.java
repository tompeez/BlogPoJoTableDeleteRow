package de.hahn.blog.pojodeletetablerow.view.beans;


import de.hahn.blog.pojodeletetablerow.view.common.PhoneInfoDTO;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.event.ActionEvent;

import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.context.AdfFacesContext;


/**
 * Class to handle table data and events on it
 */
public class TableHandlerBean {
    private static ADFLogger logger = ADFLogger.createADFLogger(TableHandlerBean.class);
    ArrayList<PhoneInfoDTO> phoneInfoList;
    Integer currentSelectedIndex;

    /**
     * c'tor
     */
    public TableHandlerBean() {
    }

    /**
     * Initalizing the List for the table model
     * This is only done once.
     */
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

    /**
     * setter for the list of objects
     * @param phoneInfoList the List
     */
    public void setPhoneInfoList(List<PhoneInfoDTO> phoneInfoList) {
        this.phoneInfoList = new ArrayList<PhoneInfoDTO>(phoneInfoList);
    }

    /**
     * getter for the list of objects
     *
     * @return list of objects
     */
    public List<PhoneInfoDTO> getPhoneInfoList() {
        // layz init ist
        if (phoneInfoList == null) {
            initList();
        }
        return phoneInfoList;
    }

    /**
     * Listener for the remove button in a table row
     * @param actionEvent tigger of the event
     */
    public void onRemoveAction(ActionEvent actionEvent) {
        // Get the index to remove
        Integer currentIndex = getCurrentSelectedIndex();
        logger.info("Removing with index : >> " + currentIndex);
        logger.info("Removing with size : >> " + phoneInfoList.size());
        logger.info("Value in List ** " + phoneInfoList.get(currentIndex).getSequence() + " phone " + phoneInfoList.get(currentIndex).getPhoneType());
        // remove the index. Here we need t opass the int value as the Integer would be interpreted as object to delete. As this object can't be found
        // the list would stay as is. There wouldn't even an error message.
        // To find out if the object was removed you hav eto check the return value. If it's not null it is the element which has been removed.
        PhoneInfoDTO dTO = phoneInfoList.remove(currentIndex.intValue());
        logger.info("size after removing : >> " + phoneInfoList.size());
        if (dTO == null) {
            logger.warning("Element with index " + currentIndex + " not found in list!");
        }
        // get the source and trigger a ppr on the container the table resides in
        UIComponent ui = (UIComponent)actionEvent.getSource();
        AdfFacesContext.getCurrentInstance().addPartialTarget(ui.getParent().getParent().getParent());
    }

    /**
     * setter for the currentIndex of the row to be removed
     * @param currentSelectedImdex index to be removed
     */
    public void setCurrentSelectedIndex(Integer currentSelectedImdex) {
        this.currentSelectedIndex = currentSelectedImdex;
    }

    /**
     * getter for the CurrentIndex of the row to remove
     * @return currentIndex of the row to remove
     */
    public Integer getCurrentSelectedIndex() {
        return currentSelectedIndex;
    }
}
