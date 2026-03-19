class StudentNode:
    def __init__(self, roll_no, name, age, grade):
        self.roll_no = roll_no
        self.name = name
        self.age = age
        self.grade = grade
        self.next = None

class StudentLinkedList:
    def __init__(self):
        self.head = None

    def add_student(self, roll_no, name, age, grade):
        new_node = StudentNode(roll_no, name, age, grade)
        new_node.next = self.head
        self.head = new_node

    def delete_student(self, roll_no):
        curr = self.head
        prev = None
        while curr and curr.roll_no != roll_no:
            prev = curr
            curr = curr.next
        if not curr: return False # Not found
        if not prev: self.head = curr.next # Delete head
        else: prev.next = curr.next
        return True

    def search_student(self, roll_no):
        curr = self.head
        while curr:
            if curr.roll_no == roll_no: return curr
            curr = curr.next
        return None

    def update_grade(self, roll_no, new_grade):
        student = self.search_student(roll_no)
        if student: student.grade = new_grade

    def display(self):
        curr = self.head
        while curr:
            print(f"[{curr.roll_no}] {curr.name}, Age: {curr.age}, Grade: {curr.grade}")
            curr = curr.next