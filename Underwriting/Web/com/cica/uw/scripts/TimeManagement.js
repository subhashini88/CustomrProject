if(window.parent.taskModel!=undefined)
{
	var taskdata = window.parent.taskModel.applicationDefinition;
	var taskid = taskdata.getElementsByTagName('TaskId')[0].innerHTML; // Get Current TaskId
	var taskname = taskdata.getElementsByTagName('Activity')[0].innerHTML; // Get Current Task Name
	var processname = taskdata.getElementsByTagName('ProcessName')[0].innerHTML; // Get Current Task Process name
	var assignee = taskdata.getElementsByTagName('Assignee')[0].innerHTML; // Get  assignee for  Current Task
	//var caseId = taskdata.getElementsByTagName("TaskData")[0].getElementsByTagName("ApplicationData")[0].getElementsByTagName("proc:forminputdata")[0].getElementsByTagName("proc:freeformcontrols")[0].getElementsByTagName("proc:opCaseid")[0].innerHTML; // Get  CaseId for  Current case
	var caseinstid = window.parent.parent.parentWindow.workflowEnablingObj.getCaseInstanceId();

	var sessionid = "";
	var logged_user = window.parent.getUserDN().split(",")[0].split("=")[1];
	var inserttimereq;
	var updatetimerreq;
	var state;
	var presenttask_id = "";
	var presentObj_id = "";
	var isAssignee = false;
	var claimed = false;
	var revoked = false;
	
	var appWindow = parent.cordys.view.system.containers.hasOwnProperty('cordys_notif_MyInboxTask') ? (parent.cordys.view.system.containers.cordys_notif_MyInboxTask.applicationWindow) : (parent.cordys.view.system.containers);
	var inboxAjax = (appWindow.hasOwnProperty('$') && appWindow.$.hasOwnProperty('cordys') && appWindow.$.cordys.hasOwnProperty('ajax'));
	var custSearchAjax = false;
	var temp;
	var index=-1;
	if(!inboxAjax){
		temp = Object.keys(parent.cordys.view.system.containers);
				
				for(var i in temp){
					if(temp[i].startsWith("Custom Search") || temp[i].startsWith("PolicySearch")){
						
						index = i;
					}
				}
				if(index != -1){
					var tempObj = parent.cordys.view.system.containers[temp[index]].applicationWindow;
					custSearchAjax = (tempObj.hasOwnProperty('$') && tempObj.$.hasOwnProperty('cordys') && tempObj.$.cordys.hasOwnProperty('ajax'));
				}
		
	}
	
	parent.parent.parent.document.getElementById("forwardTaskTableButton").disabled = true; // Disable Forward task icon.
			if(parent.parent.parent.document.getElementById("claimTaskTableButton")!=null)
				parent.parent.parent.document.getElementById("claimTaskTableButton").addEventListener("click", claimtask); // Add Event listener for Claim Task while open task
			if(parent.parent.parent.document.getElementById("revokeTaskTableButton")!=null)
				parent.parent.parent.document.getElementById("revokeTaskTableButton").addEventListener("click", revoketask); // Add Event listener for Revoke Task while open task
			if(parent.parent.parent.document.getElementById("startTaskTableButton")!=null)
				parent.parent.parent.document.getElementById("startTaskTableButton").addEventListener("click", starttask); // Add Event listener for start Task while open task
			if(parent.parent.parent.document.getElementById("pauseTaskTableButton")!=null)
				parent.parent.parent.document.getElementById("pauseTaskTableButton").addEventListener("click", stoptask); // Add Event listener for pause Task while open task
			if(parent.parent.parent.document.getElementById("resumeTaskTableButton")!=null)
				parent.parent.parent.document.getElementById("resumeTaskTableButton").addEventListener("click", ResumeTask); // Add Event listener for resume Task while open task
	
	//ajax call.
	function callAjax(method, inputParameter){
		if(inboxAjax){
			return parent.cordys.view.system.containers.cordys_notif_MyInboxTask.applicationWindow.$.cordys.ajax({
			method: method,
			namespace: "http://schemas.cordys.com/uw/dataservices/1.0",
			parameters: inputParameter,
			async: true,

		});
		}else{
			return parent.cordys.view.system.containers[temp[index]].applicationWindow.$.cordys.ajax({
			method: method,
			namespace: "http://schemas.cordys.com/uw/dataservices/1.0",
			parameters: inputParameter,
			async: true,

		});
		}
	}
	var init_TMCalled = false;
	function Init_TM() {
		//added to stop calling this function in all xforms.
		if(init_TMCalled){
			return;
		}
		sessionid = new Date().getTime(); // Session value for for unique i of Timer (Application) table
		//check is Assignee.
		if (claimed || (window.parent.taskModel.applicationDefinition.getElementsByTagName('Assignee')[0].innerHTML) == window.parent.getUserDN()) {
			isAssignee = true;
		}
		if(revoked){
			isAssignee = false;
		}
				
		getAuditDetailsbyTaskanduser(); //If user opens tasks corresponding user id combination with task id  need to check its present in Timer table
		if (presenttask_id == "") { //If not Present need to add new entry for user as state as START
			state = "START";
		} else {
			state = ""; // Else state can define as per application perspective
		}
		inserttime();

	}

	function getAuditDetailsbyTaskanduser() {
		//condition to call web service using ajax.
		var inputParameter = {
			'USER_ID' : logged_user,
			'CaseInstId': caseinstid
		};
		if(inboxAjax || custSearchAjax){
			var getAuditforUser = callAjax("getAuditDetailsforTaskbyUserID", inputParameter)
			getAuditforUser.then(function(r){
			if (r.hasOwnProperty('tuple')) {
            if (Array.isArray(r.tuple)) {
                presenttask_id = r.tuple[0].old.TIMER.TASK_ID;
                //presentObj_id = response.tuple.old.TIMER.Id;
            } else {
                presenttask_id = r.tuple.old.TIMER.TASK_ID;
                //presentObj_id = response.tuple.old.TIMER.Id;
            }

        } else {
            presenttask_id = "";
        }
		});
		}
		else{
			var request = getAuditDetailsforTaskbyUserIDModel.getMethodRequest();
			cordys.setNodeText(request,".//*[local-name()='USER_ID']",logged_user);
			cordys.setNodeText(request,".//*[local-name()='CaseInstId']",caseinstid);
			getAuditDetailsforTaskbyUserIDModel.setMethodRequest(request);
			getAuditDetailsforTaskbyUserIDModel.reset();
			var auditData = getAuditDetailsforTaskbyUserIDModel.getData();
			presenttask_id = cordys.getNodeText(auditData,".//*[local-name()='TASK_ID']","");
		}
		
	}

	function inserttime() {
		var WINDOW_ID = parent.parent.parent.frames.frameElement.parentElement.parentElement.parentElement.parentNode.id;
		
		if(inboxAjax || custSearchAjax){
			if (presenttask_id == "" || presenttask_id == undefined) {
        inserttimereq = {
            "tuple": {
                "new": {
                    "TIMER": {
                        "TASK_ID": taskid,
                        "SESSION_ID": sessionid,
                        "ACTION": state,
                        "START_TIME": getcurrentdate(),
                        "USER_ID": logged_user,
                        "TASK_NAME": taskname,
                        "PROCESS_NAME": processname,
                        "CASE_INST_ID": caseinstid,
                        "WINDOW_ID": WINDOW_ID,
                        "ASSIGNEE": (isAssignee ? 'Y' : 'N'),
                    }
                }
            }
        }
    } else {
        inserttimereq = {
            "tuple": {
                "new": {
                    "TIMER": {
                        "TASK_ID": taskid,
                        "SESSION_ID": sessionid,
                        "START_TIME": getcurrentdate(),
                        "USER_ID": logged_user,
                        "TASK_NAME": taskname,
                        "PROCESS_NAME": processname,
                        "CASE_INST_ID": caseinstid,
                        "WINDOW_ID": WINDOW_ID,
						"ASSIGNEE": (isAssignee ? 'Y' : 'N'),
                    }
                }
            }
        }

    }

    var InsertTimerModel = callAjax("UpdateTimer", inserttimereq);
    InsertTimerModel.done(function (completeResponse) {
        //console.log('Data Iserted successfully')
        //presentObj_id = completeResponse.tuple.new.TIMER.Id; //Id to update end_time
    });
		}
		else{
			if (presenttask_id == "" || presenttask_id == undefined) {
			var request = cordys.cloneXMLDocument(insertTaskTimer.XMLDocument);
			cordys.setNodeText(request,".//*[local-name()='new']//*[local-name()='TASK_ID']",taskid);
			cordys.setNodeText(request,".//*[local-name()='new']//*[local-name()='SESSION_ID']",sessionid);
			cordys.setNodeText(request,".//*[local-name()='new']//*[local-name()='ACTION']",state);
			cordys.setNodeText(request,".//*[local-name()='new']//*[local-name()='START_TIME']",getcurrentdate());
			cordys.setNodeText(request,".//*[local-name()='new']//*[local-name()='USER_ID']",logged_user);
			cordys.setNodeText(request,".//*[local-name()='new']//*[local-name()='TASK_NAME']",taskname);
			cordys.setNodeText(request,".//*[local-name()='new']//*[local-name()='PROCESS_NAME']",processname);
			cordys.setNodeText(request,".//*[local-name()='new']//*[local-name()='CASE_INST_ID']",caseinstid);
			cordys.setNodeText(request,".//*[local-name()='new']//*[local-name()='WINDOW_ID']",WINDOW_ID);
			cordys.setNodeText(request,".//*[local-name()='new']//*[local-name()='ASSIGNEE']",(isAssignee ? 'Y' : 'N'));
			UpdateTimerModel.setMethodRequest(request);
			UpdateTimerModel.reset();
		} else {
			var request = cordys.cloneXMLDocument(insertTaskTimer.XMLDocument);
			cordys.setNodeText(request,".//*[local-name()='new']//*[local-name()='TASK_ID']",taskid);
			cordys.setNodeText(request,".//*[local-name()='new']//*[local-name()='SESSION_ID']",sessionid);
			cordys.setNodeText(request,".//*[local-name()='new']//*[local-name()='START_TIME']",getcurrentdate());
			cordys.setNodeText(request,".//*[local-name()='new']//*[local-name()='USER_ID']",logged_user);
			cordys.setNodeText(request,".//*[local-name()='new']//*[local-name()='TASK_NAME']",taskname);
			cordys.setNodeText(request,".//*[local-name()='new']//*[local-name()='PROCESS_NAME']",processname);
			cordys.setNodeText(request,".//*[local-name()='new']//*[local-name()='CASE_INST_ID']",caseinstid);
			cordys.setNodeText(request,".//*[local-name()='new']//*[local-name()='WINDOW_ID']",WINDOW_ID);
			cordys.setNodeText(request,".//*[local-name()='new']//*[local-name()='ASSIGNEE']",(isAssignee ? 'Y' : 'N'));
			UpdateTimerModel.setMethodRequest(request);
			UpdateTimerModel.reset();
		}

		}
		
	}

	/*
	function openaction() {

	$.cordys.workflow.completeTask(taskid).done(function () { // function wto complete task as state is updating as END time
	parent.parent.parent.document.getElementById("refreshTaskButton").click();
	state = "END";
	updatetime();
	window.parent.application.container.close();
	});

	document.getElementById("myBtn").disabled = true;
	alert('Task Completed successfully');
	return false;

	}
	 */
	function unloadFunction_TM() { // If user close the task or switch the task
		
			state = "";
			updatetime();
			
		

	}

	function updatetime() {
		//Check from where the task has been opneed from then update end time.
			var updatetimerreq= "";
			if(parent.cordys.view.system.containers.hasOwnProperty("cordys_notif_MyInboxTask")){
				 if (state == "" || state == undefined) {
					updatetimerreq = {
						"tuple": {
							"old": {
								"TIMER": {
									"TASK_ID": taskid,
									
									"SESSION_ID": sessionid

								}
							},
							"new": {
								"TIMER": {
									"END_TIME": getcurrentdate()

								}
							}
						}
					}
				} else {
					updatetimerreq = {
						"tuple": {
							"old": {
								"TIMER": {
									"TASK_ID": taskid,
									"SESSION_ID": sessionid

								}
							},
							"new": {
								"TIMER": {
									"END_TIME": getcurrentdate(),
									"ACTION": state

								}
							}
						}
					}
				}
   
				parent.cordys.view.system.containers.cordys_notif_MyInboxTask.applicationWindow.updateTaskTimer(updatetimerreq);
			}else {
				var temp = Object.keys(parent.cordys.view.system.containers);
				var index=-1;
				for(var i in temp){
					if(temp[i].startsWith("Custom Search") || temp[i].startsWith("PolicySearch")){
						
						index = i;
					}
				}
				if(index != -1){
					//Call end time from custome search screen.
					if (state == "" || state == undefined) {
					updatetimerreq = {
						"tuple": {
							"old": {
								"TIMER": {
									"TASK_ID": taskid,
									
									"SESSION_ID": sessionid

								}
							},
							"new": {
								"TIMER": {
									"END_TIME": getcurrentdate()

								}
							}
						}
					}
				} else {
					updatetimerreq = {
						"tuple": {
							"old": {
								"TIMER": {
									"TASK_ID": taskid,
									"SESSION_ID": sessionid

								}
							},
							"new": {
								"TIMER": {
									"END_TIME": getcurrentdate(),
									"ACTION": state

								}
							}
						}
					}
				}
					parent.cordys.view.system.containers[temp[index]].applicationWindow.updateTaskTimer(updatetimerreq);
				}else{
					if (state == "" || state == undefined) {
						var request = cordys.cloneXMLDocument(updateTaskTimer.XMLDocument);
						cordys.setNodeText(request,".//*[local-name()='old']//*[local-name()='TASK_ID']",taskid);
						cordys.setNodeText(request,".//*[local-name()='old']//*[local-name()='SESSION_ID']",sessionid);
						cordys.setNodeText(request,".//*[local-name()='new']//*[local-name()='END_TIME']",getcurrentdate());
						UpdateTimerModel.setMethodRequest(request);
						UpdateTimerModel.reset();
					} else {
						var request = cordys.cloneXMLDocument(updateTaskTimer.XMLDocument);
						cordys.setNodeText(request,".//*[local-name()='old']//*[local-name()='TASK_ID']",taskid);
						cordys.setNodeText(request,".//*[local-name()='old']//*[local-name()='SESSION_ID']",sessionid);
						cordys.setNodeText(request,".//*[local-name()='new']//*[local-name()='END_TIME']",getcurrentdate());
						cordys.setNodeText(request,".//*[local-name()='new']//*[local-name()='ACTION']",state);
						UpdateTimerModel.setMethodRequest(request);
						UpdateTimerModel.reset();
					}
				}
			}
		
	}

	function starttask() { // call function while click start icon from default menu items.

		state = "START";
		//document.getElementById("myBtn").disabled = false;
		updatetime();

	}

	function stoptask() { // call function while click stop icon from default menu items.
		state = "";
		//document.getElementById("myBtn").disabled = true;
		updatetime();

	}

	function ResumeTask() { // call function while click Resume icon from default menu items.
		state = "";
		updatetime();

	}

	function claimtask() { // call function while click Claim icon from default menu items.
		revoked = false;
		state = "";
		//document.getElementById("myBtn").disabled = false;
		updatetime();
		claimed = true;
	}

	function revoketask() { // call function while click Revoke icon from default menu items.

		state = "";
		//document.getElementById("myBtn").disabled = true;
		updatetime();
		claimed = false;
		revoked = true;
		//Initiate after revoking the task.
		Init_TM();
	}

	function getcurrentdate() {
		return new Date().getUTCFullYear() + "-" + twoDigits(1 + new Date().getUTCMonth()) + "-" + twoDigits(new Date().getUTCDate()) + "T" + twoDigits(new Date().getUTCHours()) + ":" + twoDigits(new Date().getUTCMinutes()) + ":" + twoDigits(new Date().getUTCSeconds());
	}

	function twoDigits(d) {
		if (0 <= d && d < 10)
			return "0" + d.toString();
		if (-10 < d && d < 0)
			return "-0" + (-1 * d).toString();
		return d.toString();
	}
	window.onbeforeunload = function () { // Call function while Browser tab close or Browser Close
		if (!isAssignee) {
			return;
		}
		state = "";
		updatetime();

		return null;
	}

	Init_TM();
}
