package coding.challenge;

public class RedBlackTree {
    private static final int RED = 0;
    private static final int BLACK = 1;

    private final Node nil = new Node(-999);
    private Node root = nil;

    private class Node {
        int element = -999; // 더미 요소
        int color = BLACK;

        Node parent = nil;
        Node left = nil;
        Node right = nil;

        private Node(int element) {
            this.element = element;
        }
    }

    // 트리에 노드 삽입
    public void insert(int element) {
        insert(new Node(element));
    }

    private void insert(Node node) {
        Node tmp = root;

        if (root == nil) {
            root = node;
            node.color = BLACK;
            node.parent = nil;
        } else {
            node.color = RED;
            while (true) {
                if (node.element < tmp.element) {
                    if (tmp.left == nil) {
                        tmp.left = node;
                        node.parent = tmp;
                        break;
                    } else {
                        tmp = tmp.left;
                    }
                } else if (node.element >= tmp.element) {
                    if (tmp.right == nil) {
                        tmp.right = node;
                        node.parent = tmp;
                        break;
                    } else {
                        tmp = tmp.right;
                    }
                }
            }

            fixAfterInsert(node);
        }
    }

    // 트리의 노드 삭제
    public boolean delete(int element) {
        return delete(new Node(element));
    }

    private boolean delete(Node toDelete) {
        if ((toDelete = contains(toDelete, root)) == null) {
            return false;
        }

        Node p;
        Node q = toDelete;
        int qColor = q.color;

        if (toDelete.left == nil) {
            p = toDelete.right;
            replace(toDelete, toDelete.right);
        } else if (toDelete.right == nil) {
            p = toDelete.left;
            replace(toDelete, toDelete.left);
        } else {
            q = minimum(toDelete.right);
            qColor = q.color;
            p = q.right;
            if (q.parent == toDelete) {
                p.parent = q;
            } else {
                replace(q, q.right);
                q.right = toDelete.right;
                q.right.parent = q;
            }
            replace(toDelete, q);
            q.left = toDelete.left;
            q.left.parent = q;
            q.color = toDelete.color;
        }

        if (qColor == BLACK) {
            fixAfterDelete(p);
        }

        return true;
    }

    // 트리에 특정 요소가 포함되었는지 확인
    public boolean contains(int element) {
        Node result = contains(new Node(element), root);

        return result != null;
    }

    private Node contains(Node toFind, Node node) {
        if (root == nil) {
            return null;
        }

        if (toFind.element < node.element) {
            if (node.left != nil) {
                return contains(toFind, node.left);
            }
        } else if (toFind.element > node.element) {
            if (node.right != nil) {
                return contains(toFind, node.right);
            }
        } else if (toFind.element == node.element) {
            return node;
        }

        return null;
    }

    // 트리의 내용을 출력
    public void print() {
        System.out.println("In-Order Traversal:");
        print(root);
    }

    private void print(Node node) {
        if (node == nil) {
            return;
        }

        print(node.left);
        System.out.print(((node.color == RED) ? "Color: Red " : "Color: Black ")
          + "Element: " + node.element + "\n");
        print(node.right);
    }

    // 헬퍼 메서드
    private void rotateLeft(Node node) {
        if (node.parent != nil) {
            if (node == node.parent.left) {
                node.parent.left = node.right;
            } else {
                node.parent.right = node.right;
            }

            node.right.parent = node.parent;
            node.parent = node.right;

            if (node.right.left != nil) {
                node.right.left.parent = node;
            }

            node.right = node.right.left;
            node.parent.left = node;
        } else {
            // 루트 노드를 회전시킵니다.
            Node right = root.right;
            root.right = right.left;
            right.left.parent = root;
            root.parent = right;
            right.left = root;
            right.parent = nil;
            root = right;
        }
    }

    private void rotateRight(Node node) {
        if (node.parent != nil) {
            if (node == node.parent.left) {
                node.parent.left = node.left;
            } else {
                node.parent.right = node.left;
            }

            node.left.parent = node.parent;
            node.parent = node.left;

            if (node.left.right != nil) {
                node.left.right.parent = node;
            }

            node.left = node.left.right;
            node.parent.right = node;
        } else {
            // 루트 노드를 회전시킵니다.
            Node left = root.left;
            root.left = root.left.right;
            left.right.parent = root;
            root.parent = left;
            left.right = root;
            left.parent = nil;
            root = left;
        }
    }

    private void fixAfterInsert(Node node) {
        while (node.parent.color == RED) {
            Node ancestor;
            if (node.parent == node.parent.parent.left) {
                ancestor = node.parent.parent.right;

                if (ancestor != nil && ancestor.color == RED) {
                    node.parent.color = BLACK;
                    ancestor.color = BLACK;
                    node.parent.parent.color = RED;
                    node = node.parent.parent;

                    continue;
                }

                if (node == node.parent.right) {
                    // 이중 회전이 필요합니다.
                    node = node.parent;
                    rotateLeft(node);
                }

                node.parent.color = BLACK;
                node.parent.parent.color = RED;

                // 단일 회전이 필요합니다.
                rotateRight(node.parent.parent);
            } else {
                ancestor = node.parent.parent.left;
                if (ancestor != nil && ancestor.color == RED) {
                    node.parent.color = BLACK;
                    ancestor.color = BLACK;
                    node.parent.parent.color = RED;

                    node = node.parent.parent;

                    continue;
                }

                if (node == node.parent.left) {
                    // 이중 회전이 필요합니다.
                    node = node.parent;
                    rotateRight(node);
                }

                node.parent.color = BLACK;
                node.parent.parent.color = RED;

                // 단일 회전이 필요합니다.
                rotateLeft(node.parent.parent);
            }
        }

        root.color = BLACK;
    }

    private void fixAfterDelete(Node p) {
        while (p != root && p.color == BLACK) {
            if (p == p.parent.left) {
                Node ppr = p.parent.right;

                if (ppr.color == RED) {
                    ppr.color = BLACK;
                    p.parent.color = RED;
                    rotateLeft(p.parent);
                    ppr = p.parent.right;
                }

                if (ppr.left.color == BLACK && ppr.right.color == BLACK) {
                    ppr.color = RED;
                    p = p.parent;
                    continue;
                } else if (ppr.right.color == BLACK) {
                    ppr.left.color = BLACK;
                    ppr.color = RED;
                    rotateRight(ppr);
                    ppr = p.parent.right;
                }

                if (ppr.right.color == RED) {
                    ppr.color = p.parent.color;
                    p.parent.color = BLACK;
                    ppr.right.color = BLACK;
                    rotateLeft(p.parent);
                    p = root;
                }
            } else {
                Node ppl = p.parent.left;
                if (ppl.color == RED) {
                    ppl.color = BLACK;
                    p.parent.color = RED;
                    rotateRight(p.parent);
                    ppl = p.parent.left;
                }

                if (ppl.right.color == BLACK && ppl.left.color == BLACK) {
                    ppl.color = RED;
                    p = p.parent;
                    continue;
                } else if (ppl.left.color == BLACK) {
                    ppl.right.color = BLACK;
                    ppl.color = RED;
                    rotateLeft(ppl);
                    ppl = p.parent.left;
                }

                if (ppl.left.color == RED) {
                    ppl.color = p.parent.color;
                    p.parent.color = BLACK;
                    ppl.left.color = BLACK;
                    rotateRight(p.parent);
                    p = root;
                }
            }
        }

        p.color = BLACK;
    }

    private void replace(Node p, Node q) {
        if (p.parent == nil) {
            root = q;
        } else if (p == p.parent.left) {
            p.parent.left = q;
        } else {
            p.parent.right = q;
        }

        q.parent = p.parent;
    }

    private Node minimum(Node n) {
        while (n.left != nil) {
            n = n.left;
        }
        return n;
    }
}