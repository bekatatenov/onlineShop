<#import "/spring.ftl" as spring>

<#import "partials/main.ftlh" as main/>

<@main.renderWith>
    <div class="container">
        <div class="card" style="width: 600px; padding: 10px; margin: 0 auto">
            <img src=${food.image} class="card-img-top" alt="${food.name}">
            <div class="card-body">
                <h5 class="card-title">${food.name}</h5>
                <p class="card-text">${food.description}</p>
                <p class="card-text">${food.gram} <@spring.message "Gram"/></p>
                <p class="card-text">${food.price} <@spring.message "Som"/></p>
                <p class="card-text">${food.quantity} <@spring.message "Qty"/></p>
                <p class="card-text">${food.type.name} <@spring.message "Type"/></p>
            </div>

            <div>
                <#if user??>
                    <form action="/basket/add" method="post">

                        <#if _csrf??>
                            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}"
                                   value="${(_csrf.token)!'--no-token--'}"/>
                        </#if>
                        <div>
                            <input type="hidden" name="foodId" value="${food.id}">
                            <button type="submit"><@spring.message "AddToBasket"/></button>
                        </div>
                    </form>

                    <#if addReview??>
                        <form action="/basket/review" method="post">

                            <#if _csrf??>
                                <input type="hidden" name="${(_csrf.parameterName)!'csrf'}"
                                       value="${(_csrf.token)!'--no-token--'}"/>
                            </#if>

                            <div>
                                <label class="flex flex-v-center">
                                    <input type="text" name="text" placeholder=<@spring.message "text"/>>
                                </label>
                            </div>
                            <div>
                                <input type="hidden" name="foodId" value="${food.id}">
                                <button type="submit"><@spring.message "AddReview"/></button>
                            </div>
                        </form>
                    </#if>
                </#if>
            </div>

            <div>
                <#if reviews??>
                    <#list reviews as one>
                        <div class="card" style="width: 100%">
                            <div class="card-body">
                                <p class="card-text">${one.user.userName} : ${one.name} date: ${one.date}</p>
                            </div>
                        </div>
                    </#list>
                </#if>
            </div>


        </div>

    </div>

</@main.renderWith>
