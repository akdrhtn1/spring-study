$(function(){
    selectController();
    
    btnClick();
});

function selectController(){
    
    /*이메일 입력시 직접입력으로 변경처리 */
    $('#email2').keydown(function(){
        $('#email3').val('NOT');
    });
    /*셀렉트 박스 변경 되었을 경우 */
    $('#email3').change(function(){
        if("NOT" === $('#email3 option:selected').val()){
            $('#email2').val('').focus();
        }else{
            $('#email2').val($('#email3 option:selected').val());
        }
    });
}

function btnClick(){
    $('#btnSubmit').on('click',function(){
        checkAll();
    })
}

function checkAll(){
    if(!valiUserName(inq__form.name.value)){
        return false;
    }
    if(!valiUserEmail(inq__form.email.value)){
        return false;
    }
    if(!valiUserEmail2(inq__form.email2.value)){
        return false;
    }
    if(!valiPhone(inq__form.phone.value)){
        return false;
    }
    if(!valiType()){
        return false;
    }
    if(!valiAniType()){
        return false;
    }
    if(!valiTitle(inq__form.title.value)){
        return false;
    }
    if(!valiContent(inq__form.content.value)){
        return false;
    }
    
     $('#inq__form').prop('method','POST').prop('action','/board/boardInsert').submit();
}
/*초기화 x시 val지우면됨 */
/* 이름 유효성 검사  */
function valiUserName(name){
    let nameVali = /^[가-힣a-zA-Z]+$/;
    
    if(!nameVali.test(name)){
        alert('이름은 한글, 영문자만 입력이 가능합니다.');
        $('#name').val('').focus();
        return false;
    }
    return true;
}

/* 이메일 유효성 검사 */
function valiUserEmail(email){
    let emailVali = /^[a-zA-Z0-9]{6,20}$/;

    if(!emailVali.test(email)){
        alert('이메일은 6~20자리 이내의 영문자,숫자만 입력이 가능합니다.');
        $('#email').val('').focus();
        return false;
    }
    return true;
}

function valiUserEmail2(email2){
    let email2Vali = /^[A-Za-z0-9]+[A-Za-z0-9]*[.]{1}[A-Za-z]{1,3}$/;
    if(!email2Vali.test(email2)){
        alert('이메일 형식으로 입력해주세요 ex)naver.com');
        $('#email2').val('').focus();
        return false;
    }
    return true;
}


/* 휴대폰 유효성 검사 */
function valiPhone(phone){
    let phoneVali = /^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/;
    if(!phoneVali.test(phone)){
        alert('휴대폰번호 형식으로 입력해주세요 ex)010-0000-0000');
        $('#phone').val('').focus();
        return false;
    }
    return true;
}
/* 회원유형 */
function valiType(){
    if("NOT" === $('#user_type option:selected').val()){
        $('#user_type').focus();
        alert('회원유형을 선택해주세요');
        return false;
    }
    return true;
}
/*문의유형 */
function valiAniType(){
    if("NOT" === $('#any_type option:selected').val()){
        $('#any_type').focus();
        alert('문의유형을 선택해주세요');
        return false;
    }
    return true;
}

function valiTitle(title){
    if(title === ''){
        alert('제목을 입력해주세요');
        $('#title').val('').focus();
        return false;
    }
    return true;
}

function valiContent(content){
    if(content === ''){
        alert('내용을 입력해주세요');
        $('#content').val('').focus();
        return false;
    }
    return true;
}
