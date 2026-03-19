class BookNode:
    def __init__(self, book_id, title, author, genre, status):
        self.book_id, self.title, self.author, self.genre, self.status = book_id, title, author, genre, status
        self.prev = self.next = None

class LibraryList:
    def __init__(self):
        self.head = self.tail = None
        self.count = 0

    def add_book(self, book_id, title, author, genre, status):
        new_node = BookNode(book_id, title, author, genre, status)
        self.count += 1
        if not self.head:
            self.head = self.tail = new_node
        else:
            self.tail.next = new_node
            new_node.prev = self.tail
            self.tail = new_node

    def total_books(self):
        return self.count