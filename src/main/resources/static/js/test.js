console.log("Start");



$("#btn").click(function(){
    console.log("Click");
})

$(".buttons").click(function(){
    console.log("buttons");
})

$("#test").on("click","#btn2",function(){
    
})