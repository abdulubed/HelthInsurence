$(document).ready( function () {
	 var table = $('#employeesTable').DataTable({
			"sAjaxSource": "/getallSsnRecords",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			    { "mData": "ssnNo"},
		      { "mData": "firstName" },
				  { "mData": "lastName" },
				  { "mData": "dateofbirth" },
				  { "mData": "gender" },
				  { "mData": "phno" },
				  { "mData": "state" }
			]
	 })
});