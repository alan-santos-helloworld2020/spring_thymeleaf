/**
 * 
 */
 window.onload = M.AutoInit();
 
 
 function deletar(event){
	if(!confirm("Deseja realmente excluír")){
		event.preventDefault();
		return false;
	}else{
		return true;
	}
}
 