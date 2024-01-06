# common-nanoid

Common-nanoid is a simple NanoID generator. By default, it generates a 21-character long, URL-friendly NanoId. It can
also generate NanoId with custom length and alphabet settings. Easy installation, no dependencies, supports Java 9+
modules. The generator is compatible with Java 21 and later versions.

Common-nanoid is still in development and currently implements only the most commonly used functionalities. If you
find any missing features for your project, please feel free to open an issue without hesitation.

I created common-nanoid specifically for use in my projects, and if you'd like, you can use it too.

## Usage

```java
// Generate and print implicit NanoId to console.
var implicitNanoId = NanoId.next();
System.out.println(implicitNanoId);

// Generate and print custom NanoId with specific length and alphabet to console.
var customNanoId = NanoId.next(21, "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_");
System.out.println(customNanoId);
```

## Dependency

### Maven

```xml
<dependency>
  <groupId>com.dvoraksw.cn</groupId>
  <artifactId>common-nanoid</artifactId>
  <version>0.1.0</version>
</dependency>
```

### Gradle

```
compile group: 'com.dvoraksw.cn', name: 'common-nanoid', version: '0.1.0'
```

## References

This project has been inspired by [Nano-Id](https://github.com/zelark/nano-id)
and [JNanoId](https://github.com/aventrix/jnanoid) projects. 