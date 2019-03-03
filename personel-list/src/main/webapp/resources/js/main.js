
  var app = angular.module('myapp', []);
  app.controller('myappcontroller', function($scope, $http) {

  $scope.users = []
  $scope.userform = {
  id:"",
  firstName  : "",
  lastName   : "",
  phoneNumber: ""
   };
  
  var selectedUser="";
  var add_edit=""; //add=0, edit=1.
  
  getUserDetails();
  
  function getUserDetails() {
  $http({
    method : 'GET',
    url : 'list'
   }).then(function successCallback(response) {
   $scope.users = response.data;
   }, function errorCallback(response) {
    console.log(response.statusText);
   });
  }
  
  
	 $(function(){		
		 console.log(add_edit);
			$("#dialog-add").dialog({
				  autoOpen:false,
			      resizable: false,
			      height: "auto",
			      width: 650,
			      modal: true,
			      buttons: {
			    	  "Cancel": function() {
				          $(this).dialog("close");
				        },
			        Cancel: function() {
			          $(this).dialog( "close" );
			        }
			     }
			 });
	  });
	 
	 
	 $scope.openDeletePopup = function(user) {
		    selectedUser=user;
		    $("#dialog-1").dialog("open");
	}
	 
	 $scope.openAddPopup=function(){
			console.log("add popup");
			add_edit=0;
			$("#dialog-add").dialog("open");
		}
	 
		$scope.openEditPopup=function(user){
			console.log("edit popup");
			add_edit=1;//edit operation...
			
			
			$scope.userform.id		    = user.id;
			$scope.userform.firstName   = user.firstName;
		    $scope.userform.lastName    = user.lastName;
		    $scope.userform.phoneNumber = user.phoneNumber;
			
			$("#dialog-add").dialog("open");
		}
		
	 
  $(function(){		
		$("#dialog-1" ).dialog({
			  autoOpen:false,
		      resizable: false,
		      height: "auto",
		      width: 400,
		      modal: true,
		      buttons: {
		        "Delete": function() {
		        	$scope.deleteUser(selectedUser);
		          $(this).dialog("close");
				  toastr.info('The user has been deleteed succesfully', 'Succesfull');
		        },
		        Cancel: function() {
		          $(this).dialog( "close" );
		        }
		     }
		 });
  });
  
 
	 
	
  
$scope.addUser = function(){
	if(add_edit=="0"){
		$http({
			method:'POST',
			url:'add_',
			data: angular.toJson($scope.userform),
			headers : {
			    'Content-Type' : 'application/json'
			    }
		}).then(function successCallback(response) {
			   getUserDetails();
			   $("#dialog-add").dialog("close");
			   clearForm();
			toastr.success('The user has been added succesfully', 'Succesfull');
		   });
	}
	else if(add_edit=="1"){
		editUser();
		getUserDetails();
		$("#dialog-add").dialog("close");
		toastr.info('The user has been updated succesfully', 'Success');
		
	}
	else{
		$("#dialog-add").dialog("close");
	}
	
}

$scope.deleteUser = function(user) {
		
   $http({
	   method : 'DELETE',
	     url : 'delete_',
	     data: angular.toJson(user),
	     headers : {
	     'Content-Type' : 'application/json'
	   }
	   }).then(function successCallback(response) {
		   getUserDetails();
	   });
  }
	
	function editUser() {
	$http({
		method : 'POST',
		url	   : 'edit_',
		data   : angular.toJson($scope.userform),
		headers : {
		     'Content-Type' : 'application/json'
		   }  
		}).then(function successCallback(response) {
			   getUserDetails();
			   clearForm();
		   });
	  }
	
	  function clearForm() {
		  	$scope.userform.id = "";
		    $scope.userform.firstName = "";
		    $scope.userform.lastName = "";
		    $scope.userform.phoneNumber = "";
		    $scope.userForm.$setPristine();
		    console.log("pristine!");
	  }
	  
 
  jQuery(function($){
	   $("#phoneNumber").mask("(999) 999-9999");
});
  

 });
  
 

