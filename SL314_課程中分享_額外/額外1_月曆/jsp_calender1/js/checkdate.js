
//-- ----------以下是檢查年月日的程式---------- --


function DaysOfTheMonth (yy, mm) {

	var monthday = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);

	if ((yy % 4 == 0 && yy % 100 != 0) || yy % 400 == 0) {
		monthday[1] = 29;
	}
	return monthday[mm];
}

function RecheckDate (theform) {
	var yy = theform.year.options[theform.year.selectedIndex].value;
	var mm = theform.month.selectedIndex;
	var dd = theform.day.selectedIndex;
	if(yy !="options" ){
	   days = DaysOfTheMonth (yy, mm-1);
	   if ( dd > days ) {
	   	theform.day.options[days].selected = true;
	   }
	   
           olddays = theform.day.length-1;
	   if ( olddays > days ) {
	   	for (i=days; i<=olddays; i++) {
	   		theform.day.options[i+1] = null;
	   	}
	   	theform.day.length = days+1;
	   }
	   if (olddays < days) {
	   	for (i=olddays; i<=days; i++) {
	   		theform.day.options[i] = new Option (i, i);
	   	}
	        theform.day.length = days+1;
	   }
	}else{ alert("請先選擇年份!");
	   theform.month.options[0].selected=true;
	   theform.day.options[0].selected=true;
	   theform.year.focus();}
}

//-- ----------以上是檢查年月日的程式---------- 

