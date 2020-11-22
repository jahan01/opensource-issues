# Organize import issue

This is minimal reproduction of https://github.com/liancheng/scalafix-organize-imports/issues/135

Focus on `src/main/scala/myfile1.scala`

**Issues found:**

1. Different ordering of `import scala.language.postfixOps` by `./gradlew scalafix` and `sbt scalafix`

   **Orginal:**

   ```scala
    import com.package1.myfile2
    import scala.language.postfixOps
    import scala.Ordering.Implicits._
    import scalikejdbc._
    import java.io.IOException
   ```

   **After `./gradlew scalfix`:**

   ```scala
    import java.io.IOException
    import scala.Ordering.Implicits._
    import scala.language.postfixOps
    import scalikejdbc._

    import com.package1.myfile2
   ```

   **After `sbt scalfix`:**

   ```scala
    import java.io.IOException
    import scala.Ordering.Implicits._
    import scalikejdbc._

    import com.package1.myfile2

    import scala.language.postfixOps
   ```

2. No new lines between groups when custom `OrganizeImports.groups` is specied in `.scalafix.conf`

   ```scala
    import java.io.IOException
    import scala.Ordering.Implicits._
    import scalikejdbc._
   ```

   I would expect a new line between all 3 imports above because they below to different groups
