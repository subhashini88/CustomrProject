/*
  This class has been generated by the Code Generator
*/

package com.worksitewsapppackage;

import com.cordys.cpc.bsf.busobject.BusObjectConfig;
import com.cordys.cpc.bsf.busobject.BusObjectIterator;
import com.cordys.cpc.bsf.busobject.QueryObject;
import com.cordys.cpc.bsf.classinfo.AttributeInfo;
import com.cordys.cpc.bsf.classinfo.ClassInfo;
import com.cordys.cpc.bsf.classinfo.RelationInfo_FK;
import com.cordys.cpc.bsf.listeners.constraint.NumberValidator;
import com.cordys.cpc.bsf.listeners.constraint.StringValidator;


public abstract class WKSREALfeedBase extends com.cordys.cpc.bsf.busobject.StateBusObject
{
    // tags used in the XML document
    public final static String ATTR_id = "id";
    public final static String ATTR_ApplicationNbr = "ApplicationNbr";
    public final static String ATTR_BatchNumber = "BatchNumber";
    public final static String ATTR_ProductNo = "ProductNo";
    public final static String ATTR_ApplicationSeq = "ApplicationSeq";
    public final static String ATTR_CurrentAction = "CurrentAction";
    public final static String ATTR_WKSProcessedtime = "WKSProcessedtime";
    public final static String ATTR_WIMSProcessedtime = "WIMSProcessedtime";
    public final static String ATTR_Comments = "Comments";
    public final static String ATTR_LoadDate = "LoadDate";
    public final static String ATTR_AppRcvDate = "AppRcvDate";
    public final static String ATTR_CreatedBy = "CreatedBy";
    public final static String ATTR_CreatedOn = "CreatedOn";
    public final static String ATTR_UpdatedBy = "UpdatedBy";
    public final static String ATTR_UpdatedOn = "UpdatedOn";
    private final static String REL_WKSUWCaseObjects = "FK:WKSREALfeed[id]:WKSUWCase[WKSFeedIDs]";
    private static ClassInfo s_classInfo = null;
    public static ClassInfo _getClassInfo()//NOPMD framework ensures this is thread safe
    {
        if ( s_classInfo == null )//NOPMD
        {
            s_classInfo = newClassInfo(WKSREALfeed.class);
            s_classInfo.setTableName("WKSREALfeed");
            s_classInfo.setUIDElements(new String[]{ATTR_id});
            {
                AttributeInfo ai = new AttributeInfo(ATTR_id);
                ai.setJavaName(ATTR_id);
                ai.setColumnName(ATTR_id);
                ai.setAttributeClass(long.class);
                NumberValidator v = new NumberValidator(ATTR_id);
                ai.addConstraintHandler(v);
                s_classInfo.addAttributeInfo(ai);
            }
            {
                AttributeInfo ai = new AttributeInfo(ATTR_ApplicationNbr);
                ai.setJavaName(ATTR_ApplicationNbr);
                ai.setColumnName(ATTR_ApplicationNbr);
                ai.setAttributeClass(String.class);
                StringValidator v = new StringValidator(ATTR_ApplicationNbr);
                v.setMaxLength(10);
                ai.addConstraintHandler(v);
                s_classInfo.addAttributeInfo(ai);
            }
            {
                AttributeInfo ai = new AttributeInfo(ATTR_BatchNumber);
                ai.setJavaName(ATTR_BatchNumber);
                ai.setColumnName(ATTR_BatchNumber);
                ai.setAttributeClass(String.class);
                StringValidator v = new StringValidator(ATTR_BatchNumber);
                v.setMaxLength(10);
                ai.addConstraintHandler(v);
                s_classInfo.addAttributeInfo(ai);
            }
            {
                AttributeInfo ai = new AttributeInfo(ATTR_ProductNo);
                ai.setJavaName(ATTR_ProductNo);
                ai.setColumnName(ATTR_ProductNo);
                ai.setAttributeClass(String.class);
                StringValidator v = new StringValidator(ATTR_ProductNo);
                v.setMaxLength(100);
                ai.addConstraintHandler(v);
                s_classInfo.addAttributeInfo(ai);
            }
            {
                AttributeInfo ai = new AttributeInfo(ATTR_ApplicationSeq);
                ai.setJavaName(ATTR_ApplicationSeq);
                ai.setColumnName(ATTR_ApplicationSeq);
                ai.setAttributeClass(String.class);
                StringValidator v = new StringValidator(ATTR_ApplicationSeq);
                v.setMaxLength(10);
                ai.addConstraintHandler(v);
                s_classInfo.addAttributeInfo(ai);
            }
            {
                AttributeInfo ai = new AttributeInfo(ATTR_CurrentAction);
                ai.setJavaName(ATTR_CurrentAction);
                ai.setColumnName(ATTR_CurrentAction);
                ai.setAttributeClass(String.class);
                StringValidator v = new StringValidator(ATTR_CurrentAction);
                v.setMaxLength(100);
                ai.addConstraintHandler(v);
                s_classInfo.addAttributeInfo(ai);
            }
            {
                AttributeInfo ai = new AttributeInfo(ATTR_WKSProcessedtime);
                ai.setJavaName(ATTR_WKSProcessedtime);
                ai.setColumnName(ATTR_WKSProcessedtime);
                ai.setAttributeClass(String.class);
                StringValidator v = new StringValidator(ATTR_WKSProcessedtime);
                v.setMaxLength(40);
                ai.addConstraintHandler(v);
                s_classInfo.addAttributeInfo(ai);
            }
            {
                AttributeInfo ai = new AttributeInfo(ATTR_WIMSProcessedtime);
                ai.setJavaName(ATTR_WIMSProcessedtime);
                ai.setColumnName(ATTR_WIMSProcessedtime);
                ai.setAttributeClass(String.class);
                StringValidator v = new StringValidator(ATTR_WIMSProcessedtime);
                v.setMaxLength(40);
                ai.addConstraintHandler(v);
                s_classInfo.addAttributeInfo(ai);
            }
            {
                AttributeInfo ai = new AttributeInfo(ATTR_Comments);
                ai.setJavaName(ATTR_Comments);
                ai.setColumnName(ATTR_Comments);
                ai.setAttributeClass(String.class);
                StringValidator v = new StringValidator(ATTR_Comments);
                v.setMaxLength(1000);
                ai.addConstraintHandler(v);
                s_classInfo.addAttributeInfo(ai);
            }
            {
                AttributeInfo ai = new AttributeInfo(ATTR_LoadDate);
                ai.setJavaName(ATTR_LoadDate);
                ai.setColumnName(ATTR_LoadDate);
                ai.setAttributeClass(String.class);
                StringValidator v = new StringValidator(ATTR_LoadDate);
                v.setMaxLength(40);
                ai.addConstraintHandler(v);
                s_classInfo.addAttributeInfo(ai);
            }
            {
                AttributeInfo ai = new AttributeInfo(ATTR_AppRcvDate);
                ai.setJavaName(ATTR_AppRcvDate);
                ai.setColumnName(ATTR_AppRcvDate);
                ai.setAttributeClass(String.class);
                StringValidator v = new StringValidator(ATTR_AppRcvDate);
                v.setMaxLength(40);
                ai.addConstraintHandler(v);
                s_classInfo.addAttributeInfo(ai);
            }
            {
                AttributeInfo ai = new AttributeInfo(ATTR_CreatedBy);
                ai.setJavaName(ATTR_CreatedBy);
                ai.setColumnName(ATTR_CreatedBy);
                ai.setAttributeClass(String.class);
                StringValidator v = new StringValidator(ATTR_CreatedBy);
                v.setMaxLength(50);
                ai.addConstraintHandler(v);
                s_classInfo.addAttributeInfo(ai);
            }
            {
                AttributeInfo ai = new AttributeInfo(ATTR_CreatedOn);
                ai.setJavaName(ATTR_CreatedOn);
                ai.setColumnName(ATTR_CreatedOn);
                ai.setAttributeClass(java.util.Date.class);
                s_classInfo.addAttributeInfo(ai);
            }
            {
                AttributeInfo ai = new AttributeInfo(ATTR_UpdatedBy);
                ai.setJavaName(ATTR_UpdatedBy);
                ai.setColumnName(ATTR_UpdatedBy);
                ai.setAttributeClass(String.class);
                StringValidator v = new StringValidator(ATTR_UpdatedBy);
                v.setMaxLength(50);
                ai.addConstraintHandler(v);
                s_classInfo.addAttributeInfo(ai);
            }
            {
                AttributeInfo ai = new AttributeInfo(ATTR_UpdatedOn);
                ai.setJavaName(ATTR_UpdatedOn);
                ai.setColumnName(ATTR_UpdatedOn);
                ai.setAttributeClass(java.util.Date.class);
                s_classInfo.addAttributeInfo(ai);
            }
            {
                // relation WKSUWCaseObjects (FK:WKSREALfeed[id]:WKSUWCase[WKSFeedIDs])
                RelationInfo_FK ri = new RelationInfo_FK(REL_WKSUWCaseObjects);
                ri.setName("WKSUWCaseObjects");
                ri.setLocalAttributes(new String[]{ATTR_id});
                ri.setLocalIsPK(true);
                ri.setRelatedClass(com.worksitewsapppackage.WKSUWCase.class);
                ri.setRelatedAttributes(new String[]{"WKSFeedIDs"});//NOPMD
                ri.setRelatedIdentifier("FK:WKSUWCase[WKSFeedIDs]:WKSREALfeed[id]");
                ri.setLoadMethod("loadWKSUWCaseObjects");
                s_classInfo.addRelationInfo(ri);
            }
        }
        return s_classInfo;
    }

    public WKSREALfeedBase(BusObjectConfig config)
    {
        super(config);
    }

    public long getId()
    {
        return getLongProperty(ATTR_id);
    }

    public void setId(long value)
    {
        setProperty(ATTR_id, value, 0);
    }

    public String getApplicationNbr()
    {
        return getStringProperty(ATTR_ApplicationNbr);
    }

    public void setApplicationNbr(String value)
    {
        setProperty(ATTR_ApplicationNbr, value, 0);
    }

    public String getBatchNumber()
    {
        return getStringProperty(ATTR_BatchNumber);
    }

    public void setBatchNumber(String value)
    {
        setProperty(ATTR_BatchNumber, value, 0);
    }

    public String getProductNo()
    {
        return getStringProperty(ATTR_ProductNo);
    }

    public void setProductNo(String value)
    {
        setProperty(ATTR_ProductNo, value, 0);
    }

    public String getApplicationSeq()
    {
        return getStringProperty(ATTR_ApplicationSeq);
    }

    public void setApplicationSeq(String value)
    {
        setProperty(ATTR_ApplicationSeq, value, 0);
    }

    public String getCurrentAction()
    {
        return getStringProperty(ATTR_CurrentAction);
    }

    public void setCurrentAction(String value)
    {
        setProperty(ATTR_CurrentAction, value, 0);
    }

    public String getWKSProcessedtime()
    {
        return getStringProperty(ATTR_WKSProcessedtime);
    }

    public void setWKSProcessedtime(String value)
    {
        setProperty(ATTR_WKSProcessedtime, value, 0);
    }

    public String getWIMSProcessedtime()
    {
        return getStringProperty(ATTR_WIMSProcessedtime);
    }

    public void setWIMSProcessedtime(String value)
    {
        setProperty(ATTR_WIMSProcessedtime, value, 0);
    }

    public String getComments()
    {
        return getStringProperty(ATTR_Comments);
    }

    public void setComments(String value)
    {
        setProperty(ATTR_Comments, value, 0);
    }

    public String getLoadDate()
    {
        return getStringProperty(ATTR_LoadDate);
    }

    public void setLoadDate(String value)
    {
        setProperty(ATTR_LoadDate, value, 0);
    }

    public String getAppRcvDate()
    {
        return getStringProperty(ATTR_AppRcvDate);
    }

    public void setAppRcvDate(String value)
    {
        setProperty(ATTR_AppRcvDate, value, 0);
    }

    public String getCreatedBy()
    {
        return getStringProperty(ATTR_CreatedBy);
    }

    public void setCreatedBy(String value)
    {
        setProperty(ATTR_CreatedBy, value, 0);
    }

    public java.util.Date getCreatedOn()
    {
        return getDateTimestampProperty(ATTR_CreatedOn);
    }

    public void setCreatedOn(java.util.Date value)
    {
        setProperty(ATTR_CreatedOn, value, 0);
    }

    public String getUpdatedBy()
    {
        return getStringProperty(ATTR_UpdatedBy);
    }

    public void setUpdatedBy(String value)
    {
        setProperty(ATTR_UpdatedBy, value, 0);
    }

    public java.util.Date getUpdatedOn()
    {
        return getDateTimestampProperty(ATTR_UpdatedOn);
    }

    public void setUpdatedOn(java.util.Date value)
    {
        setProperty(ATTR_UpdatedOn, value, 0);
    }

    public BusObjectIterator<WKSUWCase> getWKSUWCaseObjects()
    {
        return getMultiRelationObjects(REL_WKSUWCaseObjects);
    }
    public BusObjectIterator<WKSUWCase> loadWKSUWCaseObjects()
    {
        String queryText = "select * from \"WKSUWCase\" where \"WKSFeedIDs\" = :id";
        QueryObject query = new QueryObject(queryText);
        query.addParameter("id", "WKSUWCase.WKSFeedIDs", QueryObject.PARAM_INT, new Long(getId()));//NOPMD
        query.setResultClass(WKSUWCase.class);
        return query.getObjects();
    }


    public void addWKSUWCaseObject(WKSUWCase a_WKSUWCase)
    {
        a_WKSUWCase.setWKSFeedIDs(this.getId());
    }

    public void removeWKSUWCaseObject(WKSUWCase a_WKSUWCase)
    {
        a_WKSUWCase.setNull("WKSFeedIDs");//NOPMD
    }


    public static BusObjectIterator<com.worksitewsapppackage.WKSREALfeed> getNextWKSREALfeedObjects(long Id, com.cordys.cpc.bsf.query.Cursor cursor)
    {
        String queryText = "select * from \"WKSREALfeed\" where (\"id\" > :Id) order by \"id\" asc";
        QueryObject query = new QueryObject(queryText);
        query.addParameter("Id", "WKSREALfeed.id", QueryObject.PARAM_INT, new Long(Id));//NOPMD
        query.setResultClass(WKSREALfeed.class);
        query.setCursor(cursor);
        return query.getObjects();
    }

    public static BusObjectIterator<com.worksitewsapppackage.WKSREALfeed> getPreviousWKSREALfeedObjects(long Id, com.cordys.cpc.bsf.query.Cursor cursor)
    {
        String queryText = "select * from \"WKSREALfeed\" where (\"id\" < :Id) order by \"id\" desc";
        QueryObject query = new QueryObject(queryText);
        query.addParameter("Id", "WKSREALfeed.id", QueryObject.PARAM_INT, new Long(Id));//NOPMD
        query.setResultClass(WKSREALfeed.class);
        query.setCursor(cursor);
        return query.getObjects();
    }


    public static com.worksitewsapppackage.WKSREALfeed getWKSREALfeedObject(long Id)
    {
        String queryText = "select * from \"WKSREALfeed\" where \"id\" = :Id";
        QueryObject query = new QueryObject(queryText);
        query.addParameter("Id", "WKSREALfeed.id", QueryObject.PARAM_INT, new Long(Id));//NOPMD
        query.setResultClass(WKSREALfeed.class);
        return (WKSREALfeed)query.getObject();
    }

    public static BusObjectIterator<com.worksitewsapppackage.WKSREALfeed> getWKSREALfeedObjects(long fromId, long toId, com.cordys.cpc.bsf.query.Cursor cursor)
    {
        String queryText = "select * from \"WKSREALfeed\" where \"id\" between :fromId and :toId";
        QueryObject query = new QueryObject(queryText);
        query.addParameter("fromId", "WKSREALfeed.id", QueryObject.PARAM_INT, new Long(fromId));
        query.addParameter("toId", "WKSREALfeed.id", QueryObject.PARAM_INT, new Long(toId));
        query.setResultClass(WKSREALfeed.class);
        query.setCursor(cursor);
        return query.getObjects();
    }

    public static BusObjectIterator<com.worksitewsapppackage.WKSREALfeed> getWKSREALfeedObjects(long fromId, long toId)
    {
        String queryText = "select * from \"WKSREALfeed\" where \"id\" between :fromId and :toId";
        QueryObject query = new QueryObject(queryText);
        query.addParameter("fromId", "WKSREALfeed.id", QueryObject.PARAM_INT, new Long(fromId));
        query.addParameter("toId", "WKSREALfeed.id", QueryObject.PARAM_INT, new Long(toId));
        query.setResultClass(WKSREALfeed.class);
        return query.getObjects();
    }

}
