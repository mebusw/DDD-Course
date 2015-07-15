DDD-Course
=============

This is a learning sample of [Domain Driven Design]()

## User Stories
Suppose you're admin of a training company for kids.

[Bounded Context] **Scheduling**
* Admin can create/update/delete Course.
* Admin can add courses to schedul
* Admin can know if two courses are conflicting on time/classroom.


[Bounded Context] **Enrollment**
* Guardian can enroll a course for a kid.
* Guardian can know if two courses are conflicting for the same kid.
* Admin can create/update/delete Course.
* Admin can fetch contact info of guardian for a course.

## Design Layers

* Application
* Service and Domain Objects
* Repository (CQRS, mapping between Domain objects & Persistence objects)
* Persistence (DAO, ORM etc.)

## Reference
* <http://t.cn/RLbKXZQ>
