let count = 0;
$("#fileBtn").click(function(){
    if(count < 5){
        $("#fileAdd").append('<div class="mb-3" id=""><label for="contents" class="form-label">File</label><input type="file" name="files"><button type="button" class="del">X</button></div>');
        count++;
    }
    else{
        alert("최대 파일 첨부는 5개까지 입니다.");
    }
})

$("#fileAdd").on("click",".del",function(){
    let result = window.confirm("파일을 삭제하시겠습니까?");
    if(result){
        $(this).parent().remove();
        count--;
    }
})