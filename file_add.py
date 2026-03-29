import os
import random
import math

INPUT_FOLDER = "in"
os.makedirs(INPUT_FOLDER, exist_ok=True)

line_counts = {
    "small": 1000,
    "medium": 100000,
    "big": 1000000
}

number_ranges = {
    "small": (1, 100),
    "big": (1, 100000),
    "huge": (1, 100000000)
}

distributions = [
    "random",
    "sorted_asc",
    "sorted_desc",
    "organ_pipe",
    "reverse_organ_pipe",
    "normal"
]

def file_add(n, low, high, dist):
    numbers = []
    if dist == "random":
        numbers = [random.randint(low, high) for _ in range(n)]
    elif dist == "sorted_asc":
        numbers = sorted([random.randint(low, high) for _ in range(n)])
    elif dist == "sorted_desc":
        numbers = sorted([random.randint(low, high) for _ in range(n)], reverse=True)
    elif dist == "organ_pipe":
        mid = n // 2
        left = sorted([random.randint(low, high) for _ in range(mid)])
        right = sorted([random.randint(low, high) for _ in range(n - mid)], reverse=True)
        numbers = left + right
    elif dist == "reverse_organ_pipe":
        mid = n // 2
        left = sorted([random.randint(low, high) for _ in range(mid)], reverse=True)
        right = sorted([random.randint(low, high) for _ in range(n - mid)])
        numbers = left + right
    elif dist == "normal":
        mu = (low + high) / 2
        sigma = (high - low) / 6  # ~99.7% within range
        numbers = [int(min(max(round(random.gauss(mu, sigma)), low), high)) for _ in range(n)]
    return numbers

for size_label, n in line_counts.items():
    for range_label, (low, high) in number_ranges.items():
        for dist in distributions:
            filename = f"{size_label}_{range_label}_{dist}.in"
            path = os.path.join(INPUT_FOLDER, filename)
            numbers = file_add(n, low, high, dist)
            with open(path, "w") as f:
                f.write(f"{n}\n")
                for num in numbers:
                    f.write(f"0 {num}\n")
            print(f"Generated {path}")