 function loginemail(){
            const email = document.getElementById('regEmail').value;
            if(email !== ""){
                var xhttp = new XMLHttpRequest();
                xhttp.open("GET","http://localhost:8080/loginemail?email=" + email);
                xhttp.send();
                xhttp.onload = function(){
                    document.getElementById("errormail").innerHTML = this.responseText;
                }
            }
        }
    function loginmobile() {
    const mobile = document.getElementById('regPhone').value;
    if (mobile !== "") {
        var xhttp = new XMLHttpRequest();
        xhttp.open("GET","http://localhost:8080/loginmobile?mobile=" + mobile);
        xhttp.send();
        xhttp.onload = function () {
            document.getElementById("errormobile").innerHTML = this.responseText;

        }
    }
}