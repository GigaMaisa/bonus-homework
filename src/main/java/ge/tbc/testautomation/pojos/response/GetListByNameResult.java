package ge.tbc.testautomation.pojos.response;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlType(namespace = "http://tempuri.org")
@XmlRootElement(name = "GetListByNameResult")
public class GetListByNameResult {
    private List<PersonIdentification> usersList;

    public GetListByNameResult(){}
    @XmlElement(name = "GetListByNameResult")
    public List<PersonIdentification> getUsersList() {
        return usersList;
    }

    public GetListByNameResult(List<PersonIdentification> usersList) {
        this.usersList = usersList;
    }

    public void setUsersList(List<PersonIdentification> usersList) {
        this.usersList = usersList;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
