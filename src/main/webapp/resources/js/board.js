function fn_goBackPg(){
	var referrer = document.referrer;	
	window.location.href = referrer;
};