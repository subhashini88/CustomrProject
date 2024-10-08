/*
  This class has been generated by the Code Generator
*/

package com.worksitewsapppackage;

import com.cordys.cpc.bsf.busobject.BusObjectConfig;
import com.cordys.cpc.bsf.busobject.BusObjectIterator;
import com.cordys.cpc.bsf.busobject.QueryObject;
import java.util.*;
import com.cordys.cpc.bsf.busobject.BSF;


public class ReviewActionSummary extends ReviewActionSummaryBase
{
    public ReviewActionSummary()
    {
        this((BusObjectConfig)null);
    }

    public ReviewActionSummary(BusObjectConfig config)
    {
        super(config);
    }

    public static BusObjectIterator<com.worksitewsapppackage.ReviewActionSummary> GetActivityLogByPolicy(String PolicyNumber)
    {
        String queryText = "select * from ReviewActionSummary where PolicyNbr='"+PolicyNumber+"' order by ActionDate ";
        QueryObject query = new QueryObject(queryText);
        query.addParameter("PolicyNbr", "ReviewActionSummary.PolicyNbr", QueryObject.PARAM_STRING, PolicyNumber);
        query.setResultClass(ReviewActionSummary.class);
        return query.getObjects();
    }
	public static com.worksitewsapppackage.ReviewActionSummary getLatestUplodedFile(String fileId,String ActionType)
    {
        String queryText = "select * from ReviewActionSummary where CaseNbr='"+fileId+"' and ActionType='"+ActionType+"' and actid=(select max(actid) from ReviewActionSummary where CaseNbr='"+fileId+"' and ActionType='"+ActionType+"') ";
        QueryObject query = new QueryObject(queryText);
        query.addParameter("CaseNbr", "ReviewActionSummary.CaseNbr", QueryObject.PARAM_STRING, fileId);
 query.addParameter("ActionType", "ReviewActionSummary.ActionType", QueryObject.PARAM_STRING, ActionType);
        query.setResultClass(ReviewActionSummary.class);
        return (ReviewActionSummary)query.getObject();
    }
public static com.worksitewsapppackage.ReviewActionSummary getFirstUplodedFile(String fileId)
    {
        String queryText = "select * from ReviewActionSummary where CaseNbr='"+fileId+"' and ActionType='File Original' and actid=(select Min(actid) from ReviewActionSummary where CaseNbr='"+fileId+"' and ActionType='File Original') ";
        QueryObject query = new QueryObject(queryText);
        query.addParameter("CaseNbr", "ReviewActionSummary.CaseNbr", QueryObject.PARAM_STRING, fileId);
        query.setResultClass(ReviewActionSummary.class);
        return (ReviewActionSummary)query.getObject();
    }
public static com.worksitewsapppackage.ReviewActionSummary getGIandPPBK(String CaseInstanceID,String GroupNumber,String ActionType)
    {
        String queryText = "select * from ReviewActionSummary where CaseInstId='"+CaseInstanceID+"'and PolicyNbr='"+GroupNumber+"' and ActionType='"+ActionType+"' order by ActionDate desc";
        QueryObject query = new QueryObject(queryText);
        query.addParameter("CaseInstId", "ReviewActionSummary.CaseInstId", QueryObject.PARAM_STRING, CaseInstanceID);
 query.addParameter("PolicyNbr", "ReviewActionSummary.PolicyNbr", QueryObject.PARAM_STRING, GroupNumber);
query.addParameter("ActionType", "ReviewActionSummary.ActionType", QueryObject.PARAM_STRING, ActionType);
        query.setResultClass(ReviewActionSummary.class);
        return (ReviewActionSummary)query.getObject();
    }
protected void onBeforeInsert()
{
String userDN = BSF.getUser();
this.setActionDate(new Date(new Date().getTime() - (new Date().getTimezoneOffset() * 60 * 1000)));
this.setActionBy(userDN.substring(3,userDN.indexOf(",")));
}
/*protected void onBeforeUpdate()
{
String userDN = BSF.getUser();
this.setUpdatedOn(new Date(new Date().getTime() - (new Date().getTimezoneOffset() * 60 * 1000)));
this.setUpdatedBy(userDN.substring(3,userDN.indexOf(",")));
}*/



}
