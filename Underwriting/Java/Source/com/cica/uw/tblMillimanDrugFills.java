/*
  This class has been generated by the Code Generator
*/

package com.cica.uw;

import com.cordys.cpc.bsf.busobject.BusObjectConfig;
import com.cordys.cpc.bsf.busobject.BusObjectIterator;
import com.cordys.cpc.bsf.busobject.QueryObject;


public class tblMillimanDrugFills extends tblMillimanDrugFillsBase
{
    public tblMillimanDrugFills()
    {
        this((BusObjectConfig)null);
    }

    public tblMillimanDrugFills(BusObjectConfig config)
    {
        super(config);
    }

    public static BusObjectIterator<com.cica.uw.tblMillimanDrugFills> getMillimanDrugFillsOnTrackingID(String trackingID)
    {
        String queryText = "select * from tblMillimanDrugFills where TrackingID=:trackingID order by DrugBrandName,FillDate";
        QueryObject query = new QueryObject(queryText);
		query.addParameter("trackingID", "tblMillimanDrugFills.TrackingID", QueryObject.PARAM_STRING, trackingID);
        query.setResultClass(tblMillimanDrugFills.class);        
        return query.getObjects();
    }
	
	public static BusObjectIterator<com.cica.uw.tblMillimanDrugFills> getMillimanUniqueDrugCountOnTrackingID(String trackingID)
    {
        String queryText = "with DRC(PhysicianName,DrugBrandName,DrugGenericName,DrugPriority,Indications,FillDateList,FillDateCount) AS ("
		+"select top 10000 MDR.PhysicianName,MDR.DrugBrandName,MDR.DrugGenericName,MDR.DrugPriority,MDR.Indications,LEFT(MDR.FillDateList,"
		+"LEN(MDR.FillDateList)-1) As FillDateList,(LEN(MDR.FillDateList)+2)/13 as FillDateCount From(select distinct MDRS.PhysicianName,"
		+"MDRS.DrugBrandName,MDRS.DrugGenericName,MDRS.DrugPriority,MDRS.Indications,"
		+"(select char(10) + CONVERT(varchar,MD.FillDate) + ', ' As [text()] from tblMillimanDrugFills MD "
		+"where MD.PhysicianName=MDRS.PhysicianName and MD.DrugBrandName=MDRS.DrugBrandName and MD.TrackingID=MDRS.TrackingID "
		+"and MD.DrugPriority=MDRS.DrugPriority for XML PATH(''))FillDateList from tblMillimanDrugFills MDRS where DrugPriority='HIGH' "
		+"and TrackingID=:trackingID )MDR order by MDR.DrugBrandName "
		+"union all "
		+"select top 10000 MDR.PhysicianName,MDR.DrugBrandName,MDR.DrugGenericName,MDR.DrugPriority,MDR.Indications,LEFT(MDR.FillDateList,"
		+"LEN(MDR.FillDateList)-1) As FillDateList,(LEN(MDR.FillDateList)+2)/13 as FillDateCount From(select distinct MDRS.PhysicianName,"
		+"MDRS.DrugBrandName,MDRS.DrugGenericName,MDRS.DrugPriority,MDRS.Indications,"
		+"(select char(10) + CONVERT(varchar,MD.FillDate) + ', ' As [text()] from tblMillimanDrugFills MD "
		+"where MD.PhysicianName=MDRS.PhysicianName and MD.DrugBrandName=MDRS.DrugBrandName and MD.TrackingID=MDRS.TrackingID "
		+"and MD.DrugPriority=MDRS.DrugPriority for XML PATH(''))FillDateList from tblMillimanDrugFills MDRS where DrugPriority='MEDIUM' "
		+"and TrackingID=:trackingID )MDR order by MDR.DrugBrandName "
		+"union all "
		+"select top 10000 MDR.PhysicianName,MDR.DrugBrandName,MDR.DrugGenericName,MDR.DrugPriority,MDR.Indications,LEFT(MDR.FillDateList,"
		+"LEN(MDR.FillDateList)-1) As FillDateList,(LEN(MDR.FillDateList)+2)/13 as FillDateCount From(select distinct MDRS.PhysicianName,"
		+"MDRS.DrugBrandName,MDRS.DrugGenericName,MDRS.DrugPriority,MDRS.Indications,"
		+"(select char(10) + CONVERT(varchar,MD.FillDate) + ', ' As [text()] from tblMillimanDrugFills MD "
		+"where MD.PhysicianName=MDRS.PhysicianName and MD.DrugBrandName=MDRS.DrugBrandName and MD.TrackingID=MDRS.TrackingID "
		+"and MD.DrugPriority=MDRS.DrugPriority for XML PATH(''))FillDateList from tblMillimanDrugFills MDRS where DrugPriority='LOW' "
		+"and TrackingID=:trackingID )MDR order by MDR.DrugBrandName "
		+")select DrugBrandName,DrugGenericName,PhysicianName,DrugPriority,Indications,FillDateList,FillDateCount from DRC ";
        QueryObject query = new QueryObject(queryText);
		query.addParameter("trackingID", "tblMillimanDrugFills.TrackingID", QueryObject.PARAM_STRING, trackingID);
        query.setResultClass(tblMillimanDrugFills.class);        
        return query.getObjects();
    }

}
