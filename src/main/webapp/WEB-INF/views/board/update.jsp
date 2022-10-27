<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp"></c:import>
<c:import url="../temp/summer.jsp"></c:import>
<script  defer src="/js/fileUpdate.js"></script>
</head>
<body>
	<div class="container-fluid">
	<div class="row justify-content-center">
		<div class="col-6">
		<h1>Board Update Page</h1>
		<form action="update" method="post" enctype="multipart/form-data">
			<input type="hidden" name="num" value="${vo.num }">
			<div class="mb-3">
			  <label for="title" class="form-label">Titlea</label>
			  	<input type="text" name="title" class="form-control" id="title" placeholder="제목" value="${vo.title }">
			</div>
			<div class="mb-3">
			  <label for="writer" class="form-label">Writer</label>
			  	<input type="text" name="writer" class="form-control" id="writer" placeholder="작성자" value="${vo.writer }">
			</div>
			<div class="mb-3">
			  <label for="contents" class="form-label">Contents</label>
			  <textarea class="form-control" name="contents" id="contents"></textarea>
			</div>
			
			<!--  <div class="mb-3">
			  <label for="contents" class="form-label">File</label>
			  <input type="file" name="files">
			</div>
			<div class="mb-3">
			  <label for="contents" class="form-label">File</label>
			  <input type="file" name="files">
			</div> -->
			
			<div class="mb-3" id="fileAdd">
				<c:forEach items="${vo.qnaFiles }" var="fileVO">
					<img alt="" class="filecount" src="/file/qna/${fileVO.fileName }">
					<button type="button" class="deleteFile" id="${fileVO.fileNum}">X</button>
				</c:forEach>	
			
			</div>
			<div class="mb-3">
				<button type="button" id="fileBtn">FileAdd</button>
			</div>
			
			<div>
				<button class="btn btn-danger">UPDATE</button>
			</div>
		</form>
		</div>
	</div>
	</div>
	<script type="text/javascript">
    $('#contents').summernote({
        tabsize: 4,
        height: 250
      });
    
    $('#contents').summernote('code','${vo.contents}')
	</script>
</body>
</html>