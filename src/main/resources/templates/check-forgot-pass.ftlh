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
<div>
    <p>Test Token</p>
    <p>${tok.token}</p>
</div>

<div>
    <form action="/changePass" method="post">
        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}"
                   value="${(_csrf.token)!'--no-token--'}"/>
        </#if>

        <div>
            <label class="flex flex-v-center">
                <p class="label-input-text">Token</p>
                <input type="text" name="token" placeholder="Token" value="${(form.token)!''}">
            </label>
        </div>
        <div>
            <label class="flex flex-v-center">
                <p class="label-input-text">Адрес почты:</p>
                <input type="text" name="email" placeholder="ваш адрес почты" value="${(form.email)!''}">
            </label>
        </div>
        <div>
            <label class="flex flex-v-center">
                <p class="label-input-text">New Пароль:</p>
                <input type="text" name="password" placeholder="пароль" value="">
            </label>
        </div>
        <div>
            <button type="submit">Change</button>
        </div>
    </form>
</div>

</body>
</html>