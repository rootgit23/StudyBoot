console.log("member add");

$("#all").click(function(){
    let ch = $(this).prop("checked");
    
    $(".check").prop("checked",ch);
})

$(".check").click(function(){
    let flag = true;
    $(".check").each(function(index, item){
        let check = $(item).prop("checked");
        if(!check){
            flag = false;
        }
    })
    $("#all").prop("checked",flag);
    

})

$("#joinButton").click(function(){
    let id = $("#jid").val();
    let pw = $("#jpw").val();
    let ppw = $("#jppw").val();
    let name = $("#jname").val();
    let email = $("#jemail").val();
    let check = $("#all").prop("checked");
    if(check == true){
        if(id != "" && pw != "" && ppw != "" && pw == ppw && name != "" && email != ""){
            $("#join").submit();
        }
    }
    else if(check == false){
        alert("약관에 모두 동의하세요");
        return;
    }
    else {
        alert("회원가입정보를 확인해주세요");
        return;
    }
})

$("#jid").blur(function(){
    let id = $("#jid").val();
    if(id == ""){
        alert("아이디를 입력해주세요");
        setTimeout(function(){
            $("#jid").focus();
        },10)
        return;
    }
    else{

        //$.get("./idCheck?id="+id, function(data){
            //if(data == '1'){
                //alert("아이디가 중복입니다");
            //}
            //else{
                //alert("사용가능한 아이디입니다");
            //}
        //})

        let xHttp = new XMLHttpRequest();
        xHttp.open("POST","../member/idCheck");
        xHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xHttp.send("id="+id);
        xHttp.onreadystatechange=function(){
            if(this.readyState==4 && this.status==200){
                if(this.responseText.trim()=='1'){
                    alert("아이디가 중복입니다");
                }
                else{
                    alert("사용가능한 아이디입니다");
                }
            }
        }
    }
})

$("#jpw").blur(function(){
    let pw = $("#jpw").val();
    if(pw == ""){
        alert("비밀번호를 입력해주세요");
        setTimeout(function(){
            $("#jpw").focus(); 
        },10)
        return;
    }
})


//$("#jpw").on({
    //blur:function(){
        
    //},
    //change:function(){

    //}
//})

$("#jppw").blur(function(){
    let ppw = $("#jppw").val();
    if(ppw == ""){
        alert("비밀번호가 같은지 확인해주세요");
        setTimeout(function(){
            $("#jppw").focus();
        },10)
        return;
    }

})

$("#jname").blur(function(){
    let name = $("#jname").val();
    if(name == ""){
        alert("이름을 입력해주세요");
        setTimeout(function(){
            $("#jname").focus();
        },10)
        return;
    }
})

$("#jemail").blur(function(){
    let email = $("#jemail").val();
    if(email == ""){
        alert("이메일을 입력해주세요");
        setTimeout(function(){
            $("#jemail").focus();
        },10)
        return;
    }
})