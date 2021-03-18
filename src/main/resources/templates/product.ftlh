<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <title>Search</title>
</head>
<body>
<header>
    <div class="container">
        <button class="btn btn-primary"><a style="color: black" href="/search">Search</a></button>
    </div>
</header>

<main>
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
    </#list>


    <div>
        <#list 1..pages as x>
            <a class="pageButton" href="found?text=${text}&param=${type}&page=${x}">${x}</a>
        </#list>
    </div>
</main>

</body>
</html>