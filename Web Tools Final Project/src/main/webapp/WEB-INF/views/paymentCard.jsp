<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>



<script >

function numberValidateForm()
{
  
    var x=document.forms["paymentCheck"]["cardnumber"].value;

    if(x<0){

     alert("Please enter a valid card number");
      document.paymentCheck.cardnumber.focus();
      return false;

     }



   
 
    
     
if (/[^0-9]+$/.test(x))
    {
    alert("Please enter a Card Number");
    document.paymentCheck.cardnumber.focus();
    return false;
  } 




var y=document.forms["paymentCheck"]["cvv"].value;



if(y<0){

    alert("Please enter a valid card number");
     document.paymentCheck.cvv.focus();
     return false;

    }



if (/[^0-9]+$/.test(y))
{
alert("Please enter a Card Number");
document.paymentCheck.cvv.focus();
return false;
} 
else{
   document.forms["paymentCheck"].submit();
  }

}

</script>


</head>
<body>
<% response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control","no-store");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", 0);
if(session.getAttribute("token")==null){
   response.sendRedirect("logout.htm");}%>
<div class="container">
  <form class="form-horizontal" name="paymentCheck" role="form" action="payment.htm" method="post">
    <fieldset>
      <legend>Payment</legend>
      <div class="form-group">
        <label class="col-sm-3 control-label" for="card-holder-name">Name on Card</label>
        <div class="col-sm-9">
          <input type="text" class="form-control"  required="" name="cardname" id="card-holder-name" placeholder="Card Holder's Name" required>
        </div>
      </div>
      <div class="form-group">
        <label class="col-sm-3 control-label" for="card-number">Card Number</label>
        <div class="col-sm-9">
          <input type="text" class="form-control" required="" name="cardnumber" id="card-number" placeholder="Debit/Credit Card Number" required>
        </div>
      </div>
      <div class="form-group">
        <label class="col-sm-3 control-label" required="" for="card-type">Card Type</label>
        <div class="col-sm-9">
           <div class="col-xs-3">
              <select class="form-control col-sm-2" required="" name="cardtype" id="expiry-month" >
                
                <option value="visa">Visa</option>
                <option value="mastercard">MasterCard</option>
              
              </select>
            </div>
         
        </div>
      </div>
      <div class="form-group">
        <label class="col-sm-3 control-label" for="expiry-month">Expiration Date</label>
        <div class="col-sm-9">
          <div class="row">
            <div class="col-xs-3">
              <select class="form-control col-sm-2" name="expirationmonth" id="expiry-month">
                
                <option value="01">Jan (01)</option>
                <option value="02">Feb (02)</option>
                <option value="03">Mar (03)</option>
                <option value="04">Apr (04)</option>
                <option value="05">May (05)</option>
                <option value="06">June (06)</option>
                <option value="07">July (07)</option>
                <option value="08">Aug (08)</option>
                <option value="09">Sep (09)</option>
                <option value="10">Oct (10)</option>
                <option value="11">Nov (11)</option>
                <option value="12">Dec (12)</option>
              </select>
            </div>
            <div class="col-xs-3">
              <select class="form-control" name="expirationyear">
           
                <option value="16">2016</option>
                <option value="17">2017</option>
                <option value="18">2018</option>
                <option value="19">2019</option>
                <option value="20">2020</option>
                <option value="21">2021</option>
                <option value="22">2022</option>
                <option value="23">2023</option>
                <option value="24">2024</option>
                <option value="25">2025</option>
              </select>
            </div>
          </div>
        </div>
      </div>
      <div class="form-group">
        <label class="col-sm-3 control-label" for="cvv">Card CVV</label>
        <div class="col-sm-3">
          <input type="text" class="form-control" required="" name="cvv" id="cvv" placeholder="Security Code" required>
        </div>
      </div>
      <div class="form-group">
        <div class="col-sm-offset-3 col-sm-9">
      
         <button type="button" class="btn btn-primary btn-lg" onclick="numberValidateForm()" >Pay Now</button>
        </div>
      </div>
    </fieldset>
  </form>
</div>


</body>
</html>