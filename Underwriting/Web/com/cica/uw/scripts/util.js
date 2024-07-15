function hideTheTaskAppPalettes()
{
debugger;
  if ( application.container &&
      application.container.srcApplication &&
      application.container.srcApplication.container &&
      application.container.srcApplication.container.srcApplication)
  {
           var srcApp = application.container.srcApplication.container.srcApplication;
       // Events tab of a Case-Task:
       var tab = srcApp.appPalettes["eventsApp"];
       if (tab)
       {
           tab.hide();
       }
       //tab = srcApp.appPalettes["memoApp"];
       //if (tab)
       //{
       //    tab.hide();
       //}
       tab = srcApp.appPalettes["caseAttachmentsApp"];
       if (tab)
       {
           tab.hide();
       }
       tab = srcApp.appPalettes["tagsApp"];
       if (tab)
       {
           tab.hide();
       }
       tab = srcApp.appPalettes["statusInfoApp"];
       if (tab)
       {
           tab.hide();
       }      
    }  // if app
}

function hideNonOwnerItems()
{
if ( application.container &&
      application.container.srcApplication &&
      application.container.srcApplication.container &&
      application.container.srcApplication.container.srcApplication)
  {
           var srcApp = application.container.srcApplication.container.srcApplication;

// relatedActivities tab of a Case-Task:
      tab = srcApp.appPalettes["relatedActivitiesApp"];
      if (tab)
      {
        tab.hide();
      }
      // followUps tab of a Case-Task:
      tab = srcApp.appPalettes["followupsApp"];
      if (tab)
      {
        tab.hide();
      }
}
}

