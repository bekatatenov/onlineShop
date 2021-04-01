<#import "/spring.ftl" as spring>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/css/login.css">
    <title>Sishi bar</title>
</head>
<body>

<div class="login-page">
    <div class="form">
        <form class="login-form" action="/user/login" method="post">
            <#if _csrf??>
                <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
            </#if>

            <input type="text" name="username" placeholder=<@spring.message"Your-Email"/> value="${(form.email)!''}"
                   autofocus>
            <input type="text" name="password" placeholder=<@spring.message"You-Password"/> value="">
            <button><@spring.message"LogIn"/></button>
            <p class="message"><@spring.message"NotRegist"/>? <a
                        href="/user/register"><@spring.message"CreateAccount"/></a></p>
            <p class="message"><@spring.message"ForgotPass"/>? <a
                        href="/forgotpass"><@spring.message"ResetPassword"/></a></p>
            <p class="message"><@spring.message"MainPage"/>? <a href="/"><@spring.message"Main"/></a></p>
        </form>

        <div style="padding-top: 15px">
            <form action="" method="get" class="my-3">
                <label for="lang_select">
                    <@spring.message "label.language" />:
                </label>
                <select name="lang" id="lang_select">
                    <option value="">Default</option>
                    <option value="" disabled>----------</option>
                    <option value="en-US">American English</option>
                    <option value="ru-RU">Русский</option>
                </select>
                <button type="submit">
                    <@spring.message "button.language-change.text" />
                </button>
            </form>
        </div>
    </div>
</div>
<script src="/js/login.js"></script>
</body>
</html>