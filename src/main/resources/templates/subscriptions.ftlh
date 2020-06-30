<#import "parts/common.ftlh" as c>

<@c.page>
<h3>${userChannel.username}</h3>
    <div>${type}</div>
    <#list users as user>
        <ul class="list-group">
            <li class="list-group-item">
                <a href="/user-messages/${user.id}">${user.username}</a>
            </li>
        </ul>
    </#list>
</@c.page>