var sessionid_g = new Date().getTime(); // global Session value;
var taskdata = window.parent.taskModel.applicationDefinition;
var taskid = taskdata.getElementsByTagName('TaskId')[0].innerHTML; // Get Current TaskId
// Store
//sessionStorage.setItem("lastname", "Smith");
// Retrieve
//document.getElementById("result").innerHTML = sessionStorage.getItem("lastname");

//sample data.
/*
data = {
	"sessionid" : methodname_sessionid_g,
	"request" : REQUEST_DATA,
	"Response" : RESPONSE_DATA
}
*/

var isDataEmptyforMethod = function(methodName){
	return (!(!sessionStorage.getItem(methodName)) && (("methodName"+taskid )=== sessionStorage.getItem(methodName).taskid));
}

var getSavedDataforMethod = function(methodName){
	var returnData = sessionStorage.getItem(methodName);
	if(!returnData){
		return returnData;
	}
	//parse string to XMLDocument.
	returnData = JSON.parse(returnData);
	returnData.request = new DOMParser().parseFromString(returnData.request, "application/xml");
	returnData.response = new DOMParser().parseFromString(returnData.response, "application/xml");
	return returnData;
}

var setDataformethod = function(methodName, data){
	//stringify the xmlDocuments.
	var request = new XMLSerializer().serializeToString(data.request);
	var response = new XMLSerializer().serializeToString(data.response);
	data.request = request;
	data.response = response;
	//sessionStorage.setItem(methodName, JSON.stringify(data));
}

var clearSavedData = function(methodName){
	sessionStorage.removeItem(methodName);
}

