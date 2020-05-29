$(".shopping-cart").hide();
(function() {
	$("#cart").on("click", function() {
		$(".shopping-cart").fadeToggle("fast");
	});
})();

$(document).click(function(evt){    
	if(evt.target.id == "cart"  || $(evt.target).closest("#shopping-cart_id").length > 0)
		return;
	$(".shopping-cart").hide();
});

document.getElementById("empty_cart").addEventListener("click", function() {
	var request = new XMLHttpRequest();
	request.open('GET', '/cart?funct=empty', true); 
	request.onload= function(){
	    if (request.readyState === 4) {
	        if (request.status === 200) {
	          console.log(request.responseText);
	          location.reload();
	        } else {
	          console.error(request.statusText);
	        }
	      }
	}
	request.send(null); 
	
});
