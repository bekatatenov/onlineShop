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
<form class="row g-4" style="justify-content: center" id="form-id">
    <div class="col-auto">
        <input type="text" class="form-control" name="text" id="input"
               placeholder="search" onfocus="this.value=''" autofocus>
    </div>
    <div class="col-auto">
        <select class="form-select" name="param" aria-label="Default select example">
            <option value="name">Name</option>
            <option value="type">Type</option>
            <option value="desc">Description</option>
        </select>
    </div>
    <div class="col-auto">
        <button type="submit" formaction="/found" class="btn btn-primary mb-3">Search</button>
    </div>
</form>

</body>
</html>