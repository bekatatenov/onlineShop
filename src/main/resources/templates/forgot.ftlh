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
<h1>Change Password</h1>

<form action="/user/forgot" method="post">

    <label class="flex flex-v-center">
        <p class="label-input-text">Адрес почты:</p>
        <input type="text" name="email" placeholder="ваш адрес почты" value="${(form.email)!''}">
    </label>
    </div>
    <div>
        <button type="submit">Send Email</button>
    </div>
</form>
</body>
</html>