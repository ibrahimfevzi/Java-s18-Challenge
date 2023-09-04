#  Java Spring REST API

### Proje Kurulumu

Projeyi öncelikle forklayın ve clone edin.
Daha sonra projeyi IntellijIDEA kullanarak açınız. README.md dosyasını dikkatli bir şekilde okuyarak istenenleri yapmaya çalışın.
Proje sayımız ilerledikçe proje yönetimimizi kolaylaştırmak adına projelerimizi belli klasör kalıplarında saklamak işimizi kolaylaştırmak adına iyi bir alışkanlıktır.
Örnek bir Lokasyon: Workintech/Sprint_1/Etud.

### Hedeflerimiz:

### Library Rest Api

 ### Başlangıç
 * Spring Initializr kullanarak bir Spring Boot projesi oluşturun.
 * İçerisinde ```Spring Web``` dependency eklenmeli.
 * Maven dependency management sistemini kullanarak tüm dependencyleri install edin.
 * Uygulamanızı  ```8080``` portundan ayağa kaldırın.
 * Bir banka uygulaması için rest api dizayn etmeniz istenmektedir.

### Görev 1
* Veri tabanı dizaynınız şu şekilde olmalı. Toplam 3 tablo yazmanız gerekmektedir.
* ```category``` tablosu => (id, name) kolonlarından oluşmalı.
* ```author``` tablosu => (id, first_name, last_name) bilgilerini içermeli.
* ```book``` tablosu => (id, name) bilgilerini içermeli.
* Bir kitabın sadece bir kategorisi olabilir. Ancak bir kategoride birçok kitap olabilir.
* Bir kitabın bir yazarı olabilir. Aynı şekilde bir yazar birçok kitap yazabilir


 ### Görev 2
 *  ```controller```, ```service```, ```dao```, ```entity```,  isminde 4 adet daha paket oluşturunuz.
 * ```entity``` paketinin altına ```Category```, ```Author```, ```Book``` isimli üç tane sınıf oluşturunuz.
 * ```Category```, ```Author``` ve ```Book``` sınıfları project lombok annotationlarını kullanarak oluşturulmalılar.
 * ```Category``` ve ```Book``` sınıflarının birbirleri arasındaki ilişkiyi tanımlayan annotaionları kullanın.
 * ```Book``` ve ```Author``` sınıflarının birbirleri arasındaki ilişkiyi tanımlayan annotaionları kullanın.

 ### Görev 3
 * ```AuthorController```, ```BookController```, ```CategoryController``` isimli 3 tane controller yazmalısınız.
 * Amacımız CRUD işlemlerini tanımlayan endpointler yazmak. 
 * [GET]/workintech/category => veri tabanaında kayıtlı tüm category bilgilerini döner.
 * [GET]/workintech/category/{id} => İlgili id deki category objesini döner.
 * [POST]/workintech/category => Bir adet category objesini veri tabanına ekler.
 * [PUT]/workintech/category/{id} => İlgili id deki category objesinin değerlerini günceller.
 * [DELETE]/workintech/category/{id} => İlgili id değerindeki category objesini siler.(Category silinirse, altındaki kitaplar silinmeli, mi ?)

 * [GET]/workintech/book => veri tabanında kayıtlı tüm book bilgilerini döner.
 * [GET]/workintech/book/{id} => İlgili id deki book objesini dönmeli.
 * [POST]/workintech/book/{categoryId} => İlgili categoryId ile verilen Category objesini bulup, book objesine iligli kategoriyi set edip, book objesini veritabanına kaydeder.
 * [POST]/saveByAuthor/{categoryId}/{authorId} => İlgili categoryId  ile verilen Category objesini bulup, ilgili authorId ile Author objesini bulup 2 objeyide booka ekleyip kaydetmelisiniz.
 * [PUT]/workintech/book/{id} => İlgili id deki book objesinin değerlerini günceller.
 * [DELETE]/workintech/book/{id} => İlgili id değerindeki book objesini siler.

* [GET]/workintech/author/ => veri tabanında kayıtlı tüm author bilgilerini döner.
* [GET]/workintech/author/{id} => İlgili id deki author objesini dönmeli.
* [POST]/workintech/author/ => Bir adet author objesini ver tabanına ekler
* [POST]/workintech/author/{bookId} => Parametre olarak gelen id ile ilgili book objesini bulur author a ilgili book objesini set eder. Veri tabanına ekleme yapar. 
* [PUT]/workintech/author/{authorId} =>Parametre olarak gelen id ile ilgili author objesini günceller
* [DELETE]/workintech/author/{id} => İlgili id değerindeki author objesini siler.

