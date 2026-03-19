class TextStateNode:
    def __init__(self, content):
        self.content = content
        self.prev = self.next = None

class TextEditorHistory:
    def __init__(self, limit=10):
        self.current = None
        self.limit = limit
        self.size = 0

    def add_state(self, content):
        new_node = TextStateNode(content)
        if self.current:
            self.current.next = new_node
            new_node.prev = self.current
        self.current = new_node
        # If size exceeds limit, remove the oldest node at the far left

    def undo(self):
        if self.current and self.current.prev:
            self.current = self.current.prev
            return self.current.content
        return None

    def redo(self):
        if self.current and self.current.next:
            self.current = self.current.next
            return self.current.content
        return None