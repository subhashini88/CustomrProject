function agefield_calculate(dateFieldId,ageFieldId)
{

 var inputDobFieldName = eval(dateFieldId);
 var inputAgeFieldName = eval (ageFieldId);
      var dob_value = inputDobFieldName .getFormattedValue();
    if (dob_value.length = 0 )
    {}
    else
    { 
          if (isDate(dob_value)) {

       var ageCalculated = calculateAge(dob_value, new Date());
         if (ageCalculated >= 1) {inputAgeFieldName.setValue(ageCalculated ); }
      	else
      	{ application.inform("Invalid DOB - Cannot Calculate Age") ; //DOB.setValue("") 
      	}
      } 
      else {
         application.inform("Invalid DOB - Cannot Calculate Age") ;//DOB.setValue("");
      } 
   }   
}
//convert the date string in the yyyy-mm-dd format into a JS date object
function parseDate(dateStr) {
  
  var dateParts = dateStr.split("/");
  return new Date(dateParts[1], (dateParts[1] - 1), dateParts[2]);
}

//is valid date format
function calculateAge (dateOfBirth, dateToCalculate) {
      
    var calculateYear = dateToCalculate.getFullYear();
    var calculateMonth = dateToCalculate.getMonth();
    var calculateDay = dateToCalculate.getDate();


    var dateParts = dateOfBirth.split("/");
    var birthYear = dateParts[2];
//    var birthMonth = (dateParts[0] - 1);
    var birthMonth = (dateParts[0]);
    var birthDay = dateParts[1]; 
    
   /* var birthYear = dateOfBirth.getFullYear();
    var birthMonth = dateOfBirth.getMonth();
    var birthDay = dateOfBirth.getMonth();*/


    var age = calculateYear - birthYear;
    var ageMonth = calculateMonth - birthMonth;
    var ageDay = calculateDay - birthDay;

    if (ageMonth < 0 || (ageMonth == 0 && ageDay < 0)) {
        age = parseInt(age) - 1;
    }
    return age;
}

function isDate(txtDate) {
     
  var currVal = txtDate;
  if (currVal == '')
    return true;

  //Declare Regex
 var rxDatePattern = /^(\d{1,2})(\/|-)(\d{1,2})(\/|-)(\d{4})$/;
  //var rxDatePattern = /^(\d{4})(\/|-)(\d{1,2})(\/|-)(\d{1,2})$/;
  var dtArray = currVal.match(rxDatePattern); // is format OK?

  if (dtArray == null)
    return false;

 /* //Checks for yyyy-mm-dd format.
  var dtYear = dtArray[1];
  var dtMonth = dtArray[3];
  var dtDay = dtArray[5]; */
   //Checks for dd/mm/yyyy format.
  var dtMonth = dtArray[1];
  var dtDay = dtArray[3];
  var dtYear = dtArray[5]; 

  if (dtMonth < 1 || dtMonth > 12)
    return false;
  else if (dtDay < 1 || dtDay > 31)
    return false;
  else if ((dtMonth == 4 || dtMonth == 6 || dtMonth == 9 || dtMonth == 11) && dtDay == 31)
    return false;
  else if (dtMonth == 2) {
    var isleap = (dtYear % 4 == 0 && (dtYear % 100 != 0 || dtYear % 400 == 0));
    if (dtDay > 29 || (dtDay == 29 && !isleap))
      return false;
  }

  return true;
}