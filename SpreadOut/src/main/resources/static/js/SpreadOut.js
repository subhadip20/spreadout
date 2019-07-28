$(document).ready(function(){
$("#upload-image").click(function(){
  alert("The paragraph was clicked.");
  var form = $('#imageupload')[0];

	// Create an FormData object 
  var data = new FormData(form);
console.log(data);
  $.ajax({
      type: "POST",
      enctype: 'multipart/form-data',
      url: "/admin-upload-product-image",
      data:  data,
      processData: false,
      contentType: false,
      cache: false,
      timeout: 600000,
      success: function (data) {
   var imageurl="/img/product-image/"+data;
          if(data!='error'){
        	  $("#image").val(imageurl);
        	  alert("uploaded successfully");
          }
      },
      error: function (e) {

        /*  $("#result").text(e.responseText);
          console.log("ERROR : ", e);
          $("#btnSubmit").prop("disabled", false);
*/
      }
  });
  
  
});
});


