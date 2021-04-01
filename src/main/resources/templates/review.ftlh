<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>


<#list foods as food>
<div class="card" style="width: 18rem;">
    <img src=${food.image} class="card-img-top" alt="${food.name}">
    <div class="card-body">
        <h5 class="card-title">${food.name}</h5>
        <p class="card-text">${food.description}</p>
        <p class="card-text">${food.gram} gram</p>
        <p class="card-text">${food.price} som</p>
        <p class="card-text">${food.quantity} qty</p>
        <p class="card-text">${food.type.name} type</p>
    </div>
</div>


<form action="/basket/review" method="post">

    <#if _csrf??>
        <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
    </#if>

    <div>
        <label class="flex flex-v-center">
            <p class="label-input-text">Имя:</p>
            <input type="text" name="text" placeholder="review">
        </label>
    </div>
    <div>
        <input type="hidden" name="foodId" value="${food.id}">
        <button type="submit">Write Riview</button>
    </div>
</form>
    </#list>

</body>
</html>