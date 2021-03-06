$(function(){
	parseJsonTest();
})
/*
  JSON.parse() : String -> json
  		정확한 json 법칙을 지켜야 파싱 중 에러가 안난다.
  		
  JSON.stringify() : json -> String
  		
 */
function parseJsonTest(){
	$.getJSON("resources/json/bike.json", function(data){
		
		$.ajax({
			url: "bike.do?command=second_db",
			method: "post",
			data: {"obj": JSON.stringify(data)},
			success: function(msg){
				if(msg == 1163){
					// table에 표시하자!
					// alert(msg);
					// fillTable(data);
					
					 $.each(data, function(key, val) {
		                  
		                  if(key == "DESCRIPTION") {
		                     
		                     $("table").attr("border", "1");
		                     
		                     var $tr = $("<tr>");
		                     for(var i in val) {
		                        $tr.append($("<th>").html(val[i]));
		                     }
		                     
		                     $("thead").append($tr);
		                     
		                  } else if(key == "DATA") {
		                     
		                     for(var i=0; i<val.length; i++) {
		                        var $tr = $("<tr>");
		                        
		                        for(var j in val[i]) {
		                           $tr.append($("<td>").html(val[i][j]));
		                        }
		                        
		                        $("tbody").append($tr);
		                     }
		                  }
		               });					
					
				}else{
					alert("저장 실패");
				}
				
			},
			error: function(){
				alert("통신 실패");
			}
		})
	})
}

function fillTable(data){
	console.log(data.DATA);
	$.each(data, function(key, val){
		if(key == "DESCRIPTION"){
			$("table").attr("border", "1px");
			$("thead").append($("<tr>"));
			$("thead > tr").append($("<th>").text(val.ADDR_GU));
			$("thead > tr").append($("<th>").text(val.CONTENT_ID));
			$("thead > tr").append($("<th>").text(val.CONTENT_NM));
			$("thead > tr").append($("<th>").text(val.NEW_ADDR));
			$("thead > tr").append($("<th>").text(val.CRADLE_COUNT));
			$("thead > tr").append($("<th>").text(val.LONGITUDE));
			$("thead > tr").append($("<th>").text(val.LATITUDE));
		}
		if(key = "DATA"){
			$.each(val, function(i, v){
				$("tbody").append($("<tr>"));
				$("tbody > tr").eq(i).append($("<td>").text(v.addr_gu));
				$("tbody > tr").eq(i).append($("<td>").text(v.content_id));
				$("tbody > tr").eq(i).append($("<td>").text(v.content_nm));
				$("tbody > tr").eq(i).append($("<td>").text(v.new_addr));
				$("tbody > tr").eq(i).append($("<td>").text(v.cradle_count));
				$("tbody > tr").eq(i).append($("<td>").text(v.longitude));
				$("tbody > tr").eq(i).append($("<td>").text(v.latitude));
			})
		}
	})
}