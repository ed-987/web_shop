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