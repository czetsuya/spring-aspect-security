*If you would like to support these tutorials, you can contribute to my [Patreon account](https://patreon.com/czetsuya)

# Spring Aspect Security

This project secures Spring REST endpoints using Aspect. It introduces a security interceptor
that pre-handles a REST request and where a bearer token is converted into application user.
If the user does not exist or does not have the required permission then an error will be thrown.

As a bonus, if the user is valid, it's id is saved in the request attribute and can be pass
into the REST endpoint, so that it can be used for future use.

## Build and Deploy

Go to the project root folder and run the following command:

```
mvnw install
mvnw sprint-boot:run
```

## Testing

1. Open the URL below, it should print currentUserId=1.

http://localhost:8080/employees

This endpoint is secured using Security annotation:
```
@Security(hasPermission = "employee")
```

UserId is set in SecurityInterceptor and is pass as a request attribute to the REST endpoints.
```
request.setAttribute("currentUserId", 1L);
```

Here's how we can retrieve it in a REST endpoint:
```
public void getEmployees(@RequestAttribute Long currentUserId)
```

2. Open the next URL, this one should throw an error, because the currently logged user don't
have the correct permission:
   
http://localhost:8080/employees/1

User has this permissions:
```
currentUser.setPermissions(new HashSet<>(Arrays.asList("employee", "book")));
```

But endpoint is asking for read_employee, it will throw a UserNotAuthorizedException:
```
@Security(hasPermission = "read_employee")
@GetMapping("/{id}")
public void getEmployees(@PathVariable String id, @RequestAttribute Long currentUserId) {
```

Permission checking is done at the SecurityAspect class.
