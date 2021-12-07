function loginSub(){

    let formData ={};
    $("#frm").serializeArray().map(function(x){formData[x.name] = x.value;});

    $.ajax({
        type: 'POST',
        url : '/login',
        data : JSON.stringify(formData),
        dataType : 'JSON',
        contentType : 'application/json;charset=utf-8',
        success : function(data){
            if(data == null){
                alert("아이디와 비밀번호를 확인해 주세요.!!");
            }else{
                location.href="/";
            }
        },error : function(xhr, status, error){
           alert(error, status, xhr);
        }
    });
}