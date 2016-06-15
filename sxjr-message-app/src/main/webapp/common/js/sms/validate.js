
var isIp = function (){
	    var regexp = /^\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}$/;
	             
	    return function(value){
	        var valid = regexp.test(value);
	 
	        if(!valid){//首先必须是 xxx.xxx.xxx.xxx 类型的数字，如果不是，返回false
	            return false;
	        }
	         
	        return value.split('.').every(function(num){
	            //切割开来，每个都做对比，可以为0，可以小于等于255，但是不可以0开头的俩位数
	            //只要有一个不符合就返回false
	            if(num.length > 1 && num.charAt(0) === '0'){
	                //大于1位的，开头都不可以是‘0’
	                return false;
	            }else if(parseInt(num , 10) > 255){
	                //大于255的不能通过
	                return false;
	            }
	            return true;
	        });
	    }
	}();
	
	jQuery.validator.addMethod("clientname", function(value, element) { 
		var length = value.length;  
		var namerule=/^[\u0391-\uFFE5\w!$@#&]+$/;
        return this.optional(element) || (length <= 45 && namerule.test(value));       
     }, "只能包括中文字、英文字母、数字和下划线以及!@#$特殊字符且长度不能超过45");
    jQuery.validator.addMethod("ipList", function (value, element) {
    	var isTrue = value.split(',').every(function(ip){
    		  return isIp(ip);//先将字符串按照逗号分成数组，在校验就可以了
    		});
	    return this.optional(element) || isTrue;
	}, "请输入正确的IP格式,多个IP用逗号分隔，格式如：127.0.0.1,10.10.10.1");