
$('document').ready(function(){
	
	$('table #editButton').on('click', function(event)
	{
		event.preventDefault();	
		//countries/findById/?id=1
		var href = $(this).attr('href');
		$.get(href, function(location, status)
			$('#idEdit').val(location.id);
			$('#ddlCountryEdit').val(location.countryid);
			$('#ddlStateEdit').val(location.stateid);
			$('#descriptionEdit').val(location.description);
			$('#cityEdit').val(location.city);
			$('#detailsEdit').val(location.details);
			$('#addressEdit').val(location.address);
			
		});
	
	
		$('#editModal').modal();
	});
	
	$('.table #detailsButton').on('click', function(event)
			{
				event.preventDefault();	
				//countries/findById/?id=1
				var href = $(this).attr('href');
				$.get(href, function(location, status){
					$('#idDetails').val(location.id);
					$('#ddlCountryDetail').val(location.countryid);
					$('#ddlStateDetail').val(location.stateid);
					$('#descriptionDetails').val(location.description);
					$('#detailsDetails').val(location.details);
					$('#cityDetails').val(location.city);
					$('#addressDetails').val(location.address);
					//$('#lastModifiedByDetails').val(state.lastModifiedBy)
					//$('#lastModifiedDateDetails').val(state.lastModifiedDate.substr(0,19).replace("T"," " ));
					
				});
			
			
				$('#detailsModal').modal();
			});
	
	$('table #deleteButton').on('click', function(event){
		
		event.preventDefault();
		var href = $(this).attr('href');// the url
		$('#confirmDeleteButton').attr('href', href);
		$('#deleteModal').modal();
	});
	
});