/*
  This class has been generated by the Code Generator
*/

package com.worksitewsapppackage;

import com.cordys.cpc.bsf.busobject.BusObjectConfig;
import com.cordys.cpc.bsf.busobject.BusObjectIterator;
import com.cordys.cpc.bsf.busobject.QueryObject;
import com.cordys.cpc.bsf.classinfo.AttributeInfo;
import com.cordys.cpc.bsf.classinfo.ClassInfo;
import com.cordys.cpc.bsf.listeners.constraint.NumberValidator;
import com.cordys.cpc.bsf.listeners.constraint.StringValidator;


public abstract class WKSOpsControlRepBase extends com.cordys.cpc.bsf.busobject.StateBusObject
{
    // tags used in the XML document
    public final static String ATTR_Id = "Id";
    public final static String ATTR_Group_Name = "Group_Name";
    public final static String ATTR_MasterappSFId = "MasterappSFId";
    public final static String ATTR_Company_Code = "Company_Code";
    public final static String ATTR_Case_Id = "Case_Id";
    public final static String ATTR_Group_Number = "Group_Number";
    public final static String ATTR_Agent_Name = "Agent_Name";
    public final static String ATTR_MasterAppNumber = "MasterAppNumber";
    public final static String ATTR_MA_Approved_Date = "MA_Approved_Date";
    public final static String ATTR_WIMS_Created_Date = "WIMS_Created_Date";
    public final static String ATTR_Case_Handling_Type = "Case_Handling_Type";
    public final static String ATTR_Case_Handling_Sub_Type = "Case_Handling_Sub_Type";
    public final static String ATTR_WelcomeMail_Sent = "WelcomeMail_Sent";
    public final static String ATTR_Created_Date = "Created_Date";
    public final static String ATTR_Modified_Date = "Modified_Date";
    public final static String ATTR_Enrollment_End_Date = "Enrollment_End_Date";
    public final static String ATTR_Application_Type = "Application_Type";
    private static ClassInfo s_classInfo = null;
    public static ClassInfo _getClassInfo()//NOPMD framework ensures this is thread safe
    {
        if ( s_classInfo == null )//NOPMD
        {
            s_classInfo = newClassInfo(WKSOpsControlRep.class);
            s_classInfo.setTableName("WKSOpsControlRep");
            s_classInfo.setUIDElements(new String[]{ATTR_Id});
            {
                AttributeInfo ai = new AttributeInfo(ATTR_Id);
                ai.setJavaName(ATTR_Id);
                ai.setColumnName(ATTR_Id);
                ai.setAttributeClass(long.class);
                NumberValidator v = new NumberValidator(ATTR_Id);
                ai.addConstraintHandler(v);
                s_classInfo.addAttributeInfo(ai);
            }
            {
                AttributeInfo ai = new AttributeInfo(ATTR_Group_Name);
                ai.setJavaName(ATTR_Group_Name);
                ai.setColumnName(ATTR_Group_Name);
                ai.setAttributeClass(String.class);
                StringValidator v = new StringValidator(ATTR_Group_Name);
                v.setMaxLength(100);
                ai.addConstraintHandler(v);
                s_classInfo.addAttributeInfo(ai);
            }
            {
                AttributeInfo ai = new AttributeInfo(ATTR_MasterappSFId);
                ai.setJavaName(ATTR_MasterappSFId);
                ai.setColumnName(ATTR_MasterappSFId);
                ai.setAttributeClass(String.class);
                StringValidator v = new StringValidator(ATTR_MasterappSFId);
                v.setMaxLength(100);
                ai.addConstraintHandler(v);
                s_classInfo.addAttributeInfo(ai);
            }
            {
                AttributeInfo ai = new AttributeInfo(ATTR_Company_Code);
                ai.setJavaName(ATTR_Company_Code);
                ai.setColumnName(ATTR_Company_Code);
                ai.setAttributeClass(String.class);
                StringValidator v = new StringValidator(ATTR_Company_Code);
                v.setMaxLength(10);
                ai.addConstraintHandler(v);
                s_classInfo.addAttributeInfo(ai);
            }
            {
                AttributeInfo ai = new AttributeInfo(ATTR_Case_Id);
                ai.setJavaName(ATTR_Case_Id);
                ai.setColumnName(ATTR_Case_Id);
                ai.setAttributeClass(String.class);
                StringValidator v = new StringValidator(ATTR_Case_Id);
                v.setMaxLength(20);
                ai.addConstraintHandler(v);
                s_classInfo.addAttributeInfo(ai);
            }
            {
                AttributeInfo ai = new AttributeInfo(ATTR_Group_Number);
                ai.setJavaName(ATTR_Group_Number);
                ai.setColumnName(ATTR_Group_Number);
                ai.setAttributeClass(String.class);
                StringValidator v = new StringValidator(ATTR_Group_Number);
                v.setMaxLength(500);
                ai.addConstraintHandler(v);
                s_classInfo.addAttributeInfo(ai);
            }
            {
                AttributeInfo ai = new AttributeInfo(ATTR_Agent_Name);
                ai.setJavaName(ATTR_Agent_Name);
                ai.setColumnName(ATTR_Agent_Name);
                ai.setAttributeClass(String.class);
                StringValidator v = new StringValidator(ATTR_Agent_Name);
                v.setMaxLength(100);
                ai.addConstraintHandler(v);
                s_classInfo.addAttributeInfo(ai);
            }
            {
                AttributeInfo ai = new AttributeInfo(ATTR_MasterAppNumber);
                ai.setJavaName(ATTR_MasterAppNumber);
                ai.setColumnName(ATTR_MasterAppNumber);
                ai.setAttributeClass(String.class);
                StringValidator v = new StringValidator(ATTR_MasterAppNumber);
                v.setMaxLength(100);
                ai.addConstraintHandler(v);
                s_classInfo.addAttributeInfo(ai);
            }
            {
                AttributeInfo ai = new AttributeInfo(ATTR_MA_Approved_Date);
                ai.setJavaName(ATTR_MA_Approved_Date);
                ai.setColumnName(ATTR_MA_Approved_Date);
                ai.setAttributeClass(java.util.Date.class);
                s_classInfo.addAttributeInfo(ai);
            }
            {
                AttributeInfo ai = new AttributeInfo(ATTR_WIMS_Created_Date);
                ai.setJavaName(ATTR_WIMS_Created_Date);
                ai.setColumnName(ATTR_WIMS_Created_Date);
                ai.setAttributeClass(java.util.Date.class);
                s_classInfo.addAttributeInfo(ai);
            }
            {
                AttributeInfo ai = new AttributeInfo(ATTR_Case_Handling_Type);
                ai.setJavaName(ATTR_Case_Handling_Type);
                ai.setColumnName(ATTR_Case_Handling_Type);
                ai.setAttributeClass(String.class);
                StringValidator v = new StringValidator(ATTR_Case_Handling_Type);
                v.setMaxLength(50);
                ai.addConstraintHandler(v);
                s_classInfo.addAttributeInfo(ai);
            }
            {
                AttributeInfo ai = new AttributeInfo(ATTR_Case_Handling_Sub_Type);
                ai.setJavaName(ATTR_Case_Handling_Sub_Type);
                ai.setColumnName(ATTR_Case_Handling_Sub_Type);
                ai.setAttributeClass(String.class);
                StringValidator v = new StringValidator(ATTR_Case_Handling_Sub_Type);
                v.setMaxLength(50);
                ai.addConstraintHandler(v);
                s_classInfo.addAttributeInfo(ai);
            }
            {
                AttributeInfo ai = new AttributeInfo(ATTR_WelcomeMail_Sent);
                ai.setJavaName(ATTR_WelcomeMail_Sent);
                ai.setColumnName(ATTR_WelcomeMail_Sent);
                ai.setAttributeClass(String.class);
                StringValidator v = new StringValidator(ATTR_WelcomeMail_Sent);
                v.setMaxLength(1);
                ai.addConstraintHandler(v);
                s_classInfo.addAttributeInfo(ai);
            }
            {
                AttributeInfo ai = new AttributeInfo(ATTR_Created_Date);
                ai.setJavaName(ATTR_Created_Date);
                ai.setColumnName(ATTR_Created_Date);
                ai.setAttributeClass(java.util.Date.class);
                s_classInfo.addAttributeInfo(ai);
            }
            {
                AttributeInfo ai = new AttributeInfo(ATTR_Modified_Date);
                ai.setJavaName(ATTR_Modified_Date);
                ai.setColumnName(ATTR_Modified_Date);
                ai.setAttributeClass(java.util.Date.class);
                s_classInfo.addAttributeInfo(ai);
            }
            {
                AttributeInfo ai = new AttributeInfo(ATTR_Enrollment_End_Date);
                ai.setJavaName(ATTR_Enrollment_End_Date);
                ai.setColumnName(ATTR_Enrollment_End_Date);
                ai.setAttributeClass(java.sql.Date.class);
                s_classInfo.addAttributeInfo(ai);
            }
            {
                AttributeInfo ai = new AttributeInfo(ATTR_Application_Type);
                ai.setJavaName(ATTR_Application_Type);
                ai.setColumnName(ATTR_Application_Type);
                ai.setAttributeClass(String.class);
                StringValidator v = new StringValidator(ATTR_Application_Type);
                v.setMaxLength(100);
                ai.addConstraintHandler(v);
                s_classInfo.addAttributeInfo(ai);
            }
        }
        return s_classInfo;
    }

    public WKSOpsControlRepBase(BusObjectConfig config)
    {
        super(config);
    }

    public long getId()
    {
        return getLongProperty(ATTR_Id);
    }

    public void setId(long value)
    {
        setProperty(ATTR_Id, value, 0);
    }

    public String getGroup_Name()
    {
        return getStringProperty(ATTR_Group_Name);
    }

    public void setGroup_Name(String value)
    {
        setProperty(ATTR_Group_Name, value, 0);
    }

    public String getMasterappSFId()
    {
        return getStringProperty(ATTR_MasterappSFId);
    }

    public void setMasterappSFId(String value)
    {
        setProperty(ATTR_MasterappSFId, value, 0);
    }

    public String getCompany_Code()
    {
        return getStringProperty(ATTR_Company_Code);
    }

    public void setCompany_Code(String value)
    {
        setProperty(ATTR_Company_Code, value, 0);
    }

    public String getCase_Id()
    {
        return getStringProperty(ATTR_Case_Id);
    }

    public void setCase_Id(String value)
    {
        setProperty(ATTR_Case_Id, value, 0);
    }

    public String getGroup_Number()
    {
        return getStringProperty(ATTR_Group_Number);
    }

    public void setGroup_Number(String value)
    {
        setProperty(ATTR_Group_Number, value, 0);
    }

    public String getAgent_Name()
    {
        return getStringProperty(ATTR_Agent_Name);
    }

    public void setAgent_Name(String value)
    {
        setProperty(ATTR_Agent_Name, value, 0);
    }

    public String getMasterAppNumber()
    {
        return getStringProperty(ATTR_MasterAppNumber);
    }

    public void setMasterAppNumber(String value)
    {
        setProperty(ATTR_MasterAppNumber, value, 0);
    }

    public java.util.Date getMA_Approved_Date()
    {
        return getDateTimestampProperty(ATTR_MA_Approved_Date);
    }

    public void setMA_Approved_Date(java.util.Date value)
    {
        setProperty(ATTR_MA_Approved_Date, value, 0);
    }

    public java.util.Date getWIMS_Created_Date()
    {
        return getDateTimestampProperty(ATTR_WIMS_Created_Date);
    }

    public void setWIMS_Created_Date(java.util.Date value)
    {
        setProperty(ATTR_WIMS_Created_Date, value, 0);
    }

    public String getCase_Handling_Type()
    {
        return getStringProperty(ATTR_Case_Handling_Type);
    }

    public void setCase_Handling_Type(String value)
    {
        setProperty(ATTR_Case_Handling_Type, value, 0);
    }

    public String getCase_Handling_Sub_Type()
    {
        return getStringProperty(ATTR_Case_Handling_Sub_Type);
    }

    public void setCase_Handling_Sub_Type(String value)
    {
        setProperty(ATTR_Case_Handling_Sub_Type, value, 0);
    }

    public String getWelcomeMail_Sent()
    {
        return getStringProperty(ATTR_WelcomeMail_Sent);
    }

    public void setWelcomeMail_Sent(String value)
    {
        setProperty(ATTR_WelcomeMail_Sent, value, 0);
    }

    public java.util.Date getCreated_Date()
    {
        return getDateTimestampProperty(ATTR_Created_Date);
    }

    public void setCreated_Date(java.util.Date value)
    {
        setProperty(ATTR_Created_Date, value, 0);
    }

    public java.util.Date getModified_Date()
    {
        return getDateTimestampProperty(ATTR_Modified_Date);
    }

    public void setModified_Date(java.util.Date value)
    {
        setProperty(ATTR_Modified_Date, value, 0);
    }

    public java.sql.Date getEnrollment_End_Date()
    {
        return getSqlDateProperty(ATTR_Enrollment_End_Date);
    }

    public void setEnrollment_End_Date(java.sql.Date value)
    {
        setProperty(ATTR_Enrollment_End_Date, value, 0);
    }

    public String getApplication_Type()
    {
        return getStringProperty(ATTR_Application_Type);
    }

    public void setApplication_Type(String value)
    {
        setProperty(ATTR_Application_Type, value, 0);
    }


    public static BusObjectIterator<com.worksitewsapppackage.WKSOpsControlRep> getNextWKSOpsControlRepObjects(long Id, com.cordys.cpc.bsf.query.Cursor cursor)
    {
        String queryText = "select * from \"WKSOpsControlRep\" where (\"Id\" > :Id) order by \"Id\" asc";
        QueryObject query = new QueryObject(queryText);
        query.addParameter("Id", "WKSOpsControlRep.Id", QueryObject.PARAM_INT, new Long(Id));//NOPMD
        query.setResultClass(WKSOpsControlRep.class);
        query.setCursor(cursor);
        return query.getObjects();
    }

    public static BusObjectIterator<com.worksitewsapppackage.WKSOpsControlRep> getPreviousWKSOpsControlRepObjects(long Id, com.cordys.cpc.bsf.query.Cursor cursor)
    {
        String queryText = "select * from \"WKSOpsControlRep\" where (\"Id\" < :Id) order by \"Id\" desc";
        QueryObject query = new QueryObject(queryText);
        query.addParameter("Id", "WKSOpsControlRep.Id", QueryObject.PARAM_INT, new Long(Id));//NOPMD
        query.setResultClass(WKSOpsControlRep.class);
        query.setCursor(cursor);
        return query.getObjects();
    }

    public static com.worksitewsapppackage.WKSOpsControlRep getWKSOpsControlRepObject(long Id)
    {
        String queryText = "select * from \"WKSOpsControlRep\" where \"Id\" = :Id";
        QueryObject query = new QueryObject(queryText);
        query.addParameter("Id", "WKSOpsControlRep.Id", QueryObject.PARAM_INT, new Long(Id));//NOPMD
        query.setResultClass(WKSOpsControlRep.class);
        return (WKSOpsControlRep)query.getObject();
    }

    public static BusObjectIterator<com.worksitewsapppackage.WKSOpsControlRep> getWKSOpsControlRepObjects(long fromId, long toId, com.cordys.cpc.bsf.query.Cursor cursor)
    {
        String queryText = "select * from \"WKSOpsControlRep\" where \"Id\" between :fromId and :toId";
        QueryObject query = new QueryObject(queryText);
        query.addParameter("fromId", "WKSOpsControlRep.Id", QueryObject.PARAM_INT, new Long(fromId));
        query.addParameter("toId", "WKSOpsControlRep.Id", QueryObject.PARAM_INT, new Long(toId));
        query.setResultClass(WKSOpsControlRep.class);
        query.setCursor(cursor);
        return query.getObjects();
    }

    public static BusObjectIterator<com.worksitewsapppackage.WKSOpsControlRep> getWKSOpsControlRepObjects(long fromId, long toId)
    {
        String queryText = "select * from \"WKSOpsControlRep\" where \"Id\" between :fromId and :toId";
        QueryObject query = new QueryObject(queryText);
        query.addParameter("fromId", "WKSOpsControlRep.Id", QueryObject.PARAM_INT, new Long(fromId));
        query.addParameter("toId", "WKSOpsControlRep.Id", QueryObject.PARAM_INT, new Long(toId));
        query.setResultClass(WKSOpsControlRep.class);
        return query.getObjects();
    }

}
