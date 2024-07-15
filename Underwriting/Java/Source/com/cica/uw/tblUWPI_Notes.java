


package com.cica.uw;

import com.cordys.cpc.bsf.busobject.BusObjectConfig;
import com.cordys.cpc.bsf.busobject.BusObjectIterator;
import com.cordys.cpc.bsf.busobject.QueryObject;
import java.util.*;
import com.cordys.cpc.bsf.busobject.BSF.*;
import java.sql.Timestamp;



public class tblUWPI_Notes extends tblUWPI_NotesBase
{
    public tblUWPI_Notes()
    {
        this((BusObjectConfig)null);
    }

    public tblUWPI_Notes(BusObjectConfig config)
    {
        super(config);
    }

    public static com.cica.uw.tblUWPI_Notes GetNotesDetailsbyPolicyNumber(String Policy_Number)
    {
        String queryText = "select *  from tblUWPI_Notes where Policy_Number = :Policy_Number";

        QueryObject query = new QueryObject(queryText);
        query.addParameter("Policy_Number", "tblUWPI_Notes.Policy_Number", QueryObject.PARAM_STRING, Policy_Number);//NOPMD
        query.setResultClass(tblUWPI_Notes.class);
        return (tblUWPI_Notes)query.getObject();
    }

    public static BusObjectIterator<com.cica.uw.tblUWPI_Notes> getdetailsbypitaskid(String TaskId, String screen)
    {
        String queryText ="";
if(screen != null && !screen.trim().isEmpty()){
 queryText = "select * from \"tblUWPI_Notes\" where (\"TaskId\" =:TaskId) and Screen in("+screen+" )order by \"creation_time\" desc";
//queryText="select * from tblUWPI_Notes where (TaskId = :TaskId) order by creation_time desc";
}
else
{
queryText = "select * from \"tblUWPI_Notes\" where (\"TaskId\" = :TaskId) order by \"creation_time\" desc";
//queryText="select * from tblUWPI_Notes where (Case_id =:Case_id) order by creation_time desc";
}
        QueryObject query = new QueryObject(queryText);
        query.addParameter("TaskId", "tblUWPI_Notes.TaskId", QueryObject.PARAM_STRING, TaskId);//NOPMD
        query.setResultClass(tblUWPI_Notes.class);
        return query.getObjects();
       
    }

    public static BusObjectIterator<com.cica.uw.tblUWPI_Notes> getnotesdetailsusingcaseid(String Case_id, String screen)
    {
        String queryText ="";
if(screen != null && !screen.trim().isEmpty()){
 queryText = "select * from \"tblUWPI_Notes\" where (\"Case_id\" =:Case_id) and Screen in("+screen+" )order by \"creation_time\" desc";
//queryText="select * from tblUWPI_Notes where (Case_id = :Case_id) order by creation_time desc";
}
else
{
queryText = "select * from \"tblUWPI_Notes\" where (\"Case_id\" = :Case_id) order by \"creation_time\" desc";
//queryText="select * from tblUWPI_Notes where (Case_id =:Case_id) order by creation_time desc";
}
        QueryObject query = new QueryObject(queryText);
        query.addParameter("Case_id", "tblUWPI_Notes.Case_id", QueryObject.PARAM_STRING, Case_id);//NOPMD
        query.setResultClass(tblUWPI_Notes.class);
        return query.getObjects();
    }
protected void onBeforeInsert()
{

this.setCreation_time(new Date(new Date().getTime() - (new Date().getTimezoneOffset() * 60 * 1000)));

}

}
